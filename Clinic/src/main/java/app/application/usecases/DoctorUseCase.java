package app.application.usecases;

import app.domain.model.*;
import app.domain.model.Emuns.Role;
import app.domain.ports.*;
import app.domain.services.medicalhistory.*;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Main use case class for the Doctor role.
 * Handles operations such as searching medical histories, 
 * creating and updating medical records, and generating medical orders.
 * 
 * @author Dragonico
 */

@Service
public class DoctorUseCase {

    // --------------------- CONSTANT MESSAGES (in Spanish for user feedback) ---------------------
    private static final String ERROR_EMPLOYEE_NOT_FOUND = "No se encontró el empleado con el ID: ";
    private static final String ERROR_INVALID_ROLE = "El empleado no tiene permisos para realizar acciones médicas.";
    private static final String ERROR_HISTORY_NOT_FOUND = "No se encontró la historia clínica con el ID: ";
    private static final String ERROR_NULL_HISTORY = "La historia clínica no puede ser nula.";
    private static final String ERROR_NULL_DOCTOR = "Debe asignar un médico responsable a la historia clínica.";
    private static final String ERROR_NULL_DIAGNOSIS = "La historia clínica debe contener un diagnóstico.";
    private static final String ERROR_NULL_UPDATE_DATA = "Los datos actualizados no pueden ser nulos.";
    private static final String ERROR_NULL_ORDER = "La orden médica no puede ser nula.";
    private static final String ERROR_INVALID_ORDER_ITEM = "Tipo de ítem de orden no válido: ";
    private static final String ERROR_MISSING_ASSOCIATIONS = "La orden médica debe tener asociado un paciente y un médico.";

    // --------------------- DEPENDENCIES ---------------------
    private final EmployeePort employeePort;
    private final PatientPort patientPort;
    private final MedicalHistoryPort medicalHistoryPort;
    private final OrderPort orderPort;

    // --------------------- CONSTRUCTOR ---------------------
    public DoctorUseCase(EmployeePort employeePort, PatientPort patientPort,
                         MedicalHistoryPort medicalHistoryPort, OrderPort orderPort) {
        this.employeePort = employeePort;
        this.patientPort = patientPort;
        this.medicalHistoryPort = medicalHistoryPort;
        this.orderPort = orderPort;
    }

    // --------------------- ROLE VALIDATION ---------------------
    /**
     * Validates that the employee has a Doctor role before allowing any operation.
     * 
     * @param doctorId The doctor's unique identifier.
     * @throws Exception if the employee is not found or does not have the required role.
     */
    private void validateDoctorRole(String doctorId) throws Exception {
        Employee doctor = employeePort.searchEmployeeById(doctorId);
        if (doctor == null) {
            throw new Exception(ERROR_EMPLOYEE_NOT_FOUND + doctorId);
        }
        if (doctor.getRole() != Role.DOCTOR) {
            throw new Exception(ERROR_INVALID_ROLE);
        }
    }

    // --------------------- USE CASE METHODS ---------------------

    /**
     * Searches for a patient's medical history by ID.
     * 
     * @param doctorId  The doctor performing the search.
     * @param historyId The ID of the medical history to search.
     * @return The found MedicalHistory object.
     * @throws Exception if validation fails or the history is not found.
     */
    public MedicalHistory searchMedicalHistory(String doctorId, String historyId) throws Exception {
        validateDoctorRole(doctorId);

        SearchMedicalHistoryById searchService = new SearchMedicalHistoryById(medicalHistoryPort);
        MedicalHistory history = searchService.search(historyId);

        if (history == null) {
            throw new Exception(ERROR_HISTORY_NOT_FOUND + historyId);
        }
        return history;
    }

    /**
     * Creates a new medical record (medical history).
     * 
     * @param doctorId The doctor creating the record.
     * @param history  The medical history to create.
     * @throws Exception if validation fails or data is missing.
     */
    public void createMedicalRecord(String doctorId, MedicalHistory history) throws Exception {
        validateDoctorRole(doctorId);

        if (history == null) {
            throw new Exception(ERROR_NULL_HISTORY);
        }
        if (history.getDoctor() == null) {
            throw new Exception(ERROR_NULL_DOCTOR);
        }
        if (history.getDiagnosis() == null) {
            throw new Exception(ERROR_NULL_DIAGNOSIS);
        }

        RegisterMedicalHistory registerService = new RegisterMedicalHistory(medicalHistoryPort);
        registerService.register(history);
    }

    /**
     * Updates an existing medical record.
     * 
     * @param doctorId    The doctor performing the update.
     * @param historyId   The ID of the medical history to update.
     * @param updatedData The new data to apply.
     * @throws Exception if validation fails or data is null.
     */
    public void updateMedicalRecord(String doctorId, String historyId, MedicalHistory updatedData) throws Exception {
        validateDoctorRole(doctorId);

        if (updatedData == null) {
            throw new Exception(ERROR_NULL_UPDATE_DATA);
        }

        UpdateMedicalHistory updateService = new UpdateMedicalHistory(medicalHistoryPort);
        updateService.update(historyId, updatedData);
    }

    /**
     * Creates a medical order and registers its associated items (medications, procedures, diagnostic aids).
     * 
     * @param doctorId The doctor creating the order.
     * @param order    The main order object.
     * @param items    The list of associated order items.
     * @throws Exception if validation fails or item types are invalid.
     */
    public void createOrder(String doctorId, Order order, List<Order> items) throws Exception {
        validateDoctorRole(doctorId);

        if (order == null) {
            throw new Exception(ERROR_NULL_ORDER);
        }
        if (order.getPatientId() == null || order.getDoctorId() == null) {
            throw new Exception(ERROR_MISSING_ASSOCIATIONS);
        }

        // Register main order
        orderPort.registerOrder(order);

        // Register related order items (Medication, Procedure, Diagnostic Aid)
        if (items != null && !items.isEmpty()) {
            for (Order item : items) {
                if (item instanceof MedicationOrder
                        || item instanceof ProcedureOrder
                        || item instanceof DiagnosticAidOrder) {
                    orderPort.registerOrder(item);
                } else {
                    throw new Exception(ERROR_INVALID_ORDER_ITEM + item.getClass().getSimpleName());
                }
            }
        }
    }
}
