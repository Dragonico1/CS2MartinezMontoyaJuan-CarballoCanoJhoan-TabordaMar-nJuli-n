package app.application.usecases;

import app.domain.model.*;
import app.domain.model.Emuns.Role;
import app.domain.ports.*;
import app.domain.services.medicalhistory.RegisterMedicalHistory;
import java.util.List;

/**
 * Main use case class for the Nurse role.
 * Allows registering nursing visits, searching for patients,
 * and viewing medical orders created by the doctor.
 * 
 * @author Dragonico
 */
public class NurseUseCase {

    // --------------------- CONSTANT MESSAGES (in Spanish for user feedback) ---------------------
    private static final String ERROR_EMPLOYEE_NOT_FOUND = "No se encontró el empleado con el ID: ";
    private static final String ERROR_INVALID_ROLE = "El empleado no tiene permisos para realizar acciones de enfermería.";
    private static final String ERROR_NULL_VISIT = "El registro de la visita no puede ser nulo.";
    private static final String ERROR_MISSING_DOCTOR = "Debe asignar un médico responsable al registro.";
    private static final String ERROR_EMPTY_REASON = "Debe especificar el motivo de la visita.";
    private static final String ERROR_EMPTY_PATIENT_ID = "El ID del paciente no puede estar vacío.";
    private static final String ERROR_ORDERS_NOT_FOUND = "No se encontraron órdenes médicas para el paciente con ID: ";

    // --------------------- DEPENDENCIES ---------------------
    private final EmployeePort employeePort;
    private final PatientPort patientPort;
    private final MedicalHistoryPort medicalHistoryPort;
    private final OrderPort orderPort;

    // --------------------- CONSTRUCTOR ---------------------
    public NurseUseCase(EmployeePort employeePort, PatientPort patientPort,
                        MedicalHistoryPort medicalHistoryPort, OrderPort orderPort) {
        this.employeePort = employeePort;
        this.patientPort = patientPort;
        this.medicalHistoryPort = medicalHistoryPort;
        this.orderPort = orderPort;
    }

    // --------------------- ROLE VALIDATION ---------------------
    /**
     * Validates that the employee has a Nurse role before allowing operations.
     * 
     * @param nurseId The nurse's unique identifier.
     * @throws Exception if the employee is not found or does not have the Nurse role.
     */
    private void validateNurseRole(String nurseId) throws Exception {
        Employee nurse = employeePort.searchEmployeeById(nurseId);
        if (nurse == null) {
            throw new Exception(ERROR_EMPLOYEE_NOT_FOUND + nurseId);
        }
        if (nurse.getRole() != Role.Nurse) {
            throw new Exception(ERROR_INVALID_ROLE);
        }
    }

    // --------------------- USE CASE METHODS ---------------------

    /**
     * Registers a nursing visit for a patient.
     * The visit record is stored as a medical history entry without diagnosis, 
     * containing only observations or visit reasons.
     * 
     * @param nurseId The nurse performing the registration.
     * @param visitRecord The medical history object representing the visit.
     * @throws Exception if validation fails or data is incomplete.
     */
    public void registerVisit(String nurseId, MedicalHistory visitRecord) throws Exception {
        validateNurseRole(nurseId);

        if (visitRecord == null) {
            throw new Exception(ERROR_NULL_VISIT);
        }
        if (visitRecord.getDoctor() == null) {
            throw new Exception(ERROR_MISSING_DOCTOR);
        }
        if (visitRecord.getReasonVisit() == null || visitRecord.getReasonVisit().isBlank()) {
            throw new Exception(ERROR_EMPTY_REASON);
        }

        RegisterMedicalHistory registerService = new RegisterMedicalHistory(medicalHistoryPort);
        registerService.register(visitRecord);
    }

    /**
     * Searches for a patient by their ID.
     * 
     * @param nurseId The nurse performing the search.
     * @param patientId The ID of the patient to find.
     * @return The Patient object found.
     * @throws Exception if validation fails or the ID is empty.
     */
    public Patient searchPatient(String nurseId, String patientId) throws Exception {
        validateNurseRole(nurseId);

        if (patientId == null || patientId.isBlank()) {
            throw new Exception(ERROR_EMPTY_PATIENT_ID);
        }

        return patientPort.searchPatientById(patientId);
    }

    /**
     * Retrieves the medical orders created by a doctor for a specific patient.
     * 
     * @param nurseId The nurse requesting the information.
     * @param patientId The patient's ID to search orders for.
     * @return List of medical orders associated with the patient.
     * @throws Exception if no orders are found or validation fails.
     */
    public List<Order> searchMedicalOrders(String nurseId, String patientId) throws Exception {
        validateNurseRole(nurseId);

        if (patientId == null || patientId.isBlank()) {
            throw new Exception(ERROR_EMPTY_PATIENT_ID);
        }

        List<Order> orders = orderPort.listOrdersByPatient(patientId);
        if (orders == null || orders.isEmpty()) {
            throw new Exception(ERROR_ORDERS_NOT_FOUND + patientId);
        }

        return orders;
    }
}
