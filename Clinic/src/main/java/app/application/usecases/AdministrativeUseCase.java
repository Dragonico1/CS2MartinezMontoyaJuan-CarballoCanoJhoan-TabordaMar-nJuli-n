package app.application.usecases;

import app.domain.model.*;
import app.domain.model.Emuns.Role;
import app.domain.ports.*;
import app.adapter.in.validators.AppointmentValidator;

/**
 * Main use case class for the Administrative Staff (AdminStaff) role.
 * Handles management of patients, appointments, billing, and emergency contacts.
 * 
 * @author Dragonico
 */
public class AdministrativeUseCase {

    // --------------------- CONSTANT MESSAGES (in Spanish for user feedback) ---------------------
    private static final String ERROR_UNAUTHORIZED = "Acceso denegado: el empleado no tiene rol administrativo.";
    private static final String ERROR_NULL_PATIENT = "El paciente no puede ser nulo.";
    private static final String ERROR_EMPTY_PATIENT_ID = "El ID del paciente no puede estar vacío.";
    private static final String ERROR_NULL_PATIENT_DATA = "Los datos del paciente no pueden ser nulos.";
    private static final String ERROR_NULL_APPOINTMENT = "La cita no puede ser nula.";
    private static final String ERROR_EMPTY_APPOINTMENT_ID = "El ID de la cita no puede estar vacío.";
    private static final String ERROR_NULL_APPOINTMENT_DATA = "Los datos de la cita no pueden ser nulos.";
    private static final String ERROR_NULL_BILL = "La factura no puede ser nula.";
    private static final String ERROR_NULL_CONTACT = "El contacto de emergencia no puede ser nulo.";

    // --------------------- DEPENDENCIES ---------------------
    private final PatientPort patientPort;
    private final AppointmentPort appointmentPort;
    private final BillingPort billingPort;
    private final EmergencyContactPort contactPort;
    private final AppointmentValidator appointmentValidator;

    // --------------------- CONSTRUCTOR ---------------------
    public AdministrativeUseCase(PatientPort patientPort,
                                 AppointmentPort appointmentPort,
                                 BillingPort billingPort,
                                 EmergencyContactPort contactPort) {
        this.patientPort = patientPort;
        this.appointmentPort = appointmentPort;
        this.billingPort = billingPort;
        this.contactPort = contactPort;
        this.appointmentValidator = new AppointmentValidator();
    }

    // --------------------- ROLE VALIDATION ---------------------
    /**
     * Validates that the user has an administrative role before performing any operation.
     * 
     * @param employee The employee attempting the action.
     * @throws Exception if the employee is null or does not have the AdminStaff role.
     */
    private void validateAdministrativeRole(Employee employee) throws Exception {
        if (employee == null || employee.getRole() != Role.AdminStaff) {
            throw new Exception(ERROR_UNAUTHORIZED);
        }
    }

    // --------------------- PATIENT MANAGEMENT ---------------------

    /**
     * Registers a new patient in the system.
     * 
     * @param admin The administrative employee performing the action.
     * @param patient The patient to be registered.
     * @throws Exception if validation fails.
     */
    public void registerPatient(Employee admin, Patient patient) throws Exception {
        validateAdministrativeRole(admin);

        if (patient == null) {
            throw new Exception(ERROR_NULL_PATIENT);
        }

        patientPort.registerPatient(patient);
    }

    /**
     * Updates patient information.
     * 
     * @param admin The administrative employee performing the action.
     * @param patientId The patient ID to update.
     * @param updatedPatient The new patient data.
     * @throws Exception if validation fails.
     */
    public void updatePatient(Employee admin, String patientId, Patient updatedPatient) throws Exception {
        validateAdministrativeRole(admin);

        if (patientId == null || patientId.isBlank()) {
            throw new Exception(ERROR_EMPTY_PATIENT_ID);
        }
        if (updatedPatient == null) {
            throw new Exception(ERROR_NULL_PATIENT_DATA);
        }

        patientPort.updatePatient(patientId, updatedPatient);
    }

    // --------------------- APPOINTMENT MANAGEMENT ---------------------

    /**
     * Creates a new appointment in the system.
     * 
     * @param admin The administrative employee performing the action.
     * @param appointment The appointment object to create.
     * @throws Exception if validation fails or the appointment data is invalid.
     */
    public void createAppointment(Employee admin, Appointment appointment) throws Exception {
        validateAdministrativeRole(admin);

        if (appointment == null) {
            throw new Exception(ERROR_NULL_APPOINTMENT);
        }

        appointmentValidator.validate(appointment);
        appointmentPort.scheduleAppointment(appointment);
    }

    /**
     * Updates an existing appointment.
     * 
     * @param admin The administrative employee performing the action.
     * @param appointmentId The ID of the appointment to update.
     * @param updatedAppointment The updated appointment data.
     * @throws Exception if validation fails.
     */
    public void updateAppointment(Employee admin, String appointmentId, Appointment updatedAppointment) throws Exception {
        validateAdministrativeRole(admin);

        if (appointmentId == null || appointmentId.isBlank()) {
            throw new Exception(ERROR_EMPTY_APPOINTMENT_ID);
        }
        if (updatedAppointment == null) {
            throw new Exception(ERROR_NULL_APPOINTMENT_DATA);
        }

        appointmentValidator.validate(updatedAppointment);
        appointmentPort.updateAppointment(appointmentId, updatedAppointment);
    }

    // --------------------- BILLING MANAGEMENT ---------------------

    /**
     * Generates a new billing record for a patient.
     * 
     * @param admin The administrative employee performing the action.
     * @param bill The billing object to generate.
     * @throws Exception if validation fails.
     */
    public void generateBill(Employee admin, Billing bill) throws Exception {
        validateAdministrativeRole(admin);

        if (bill == null) {
            throw new Exception(ERROR_NULL_BILL);
        }

        billingPort.generateBill(bill);
    }

    // --------------------- EMERGENCY CONTACT MANAGEMENT ---------------------

    /**
     * Registers a new emergency contact.
     * 
     * @param admin The administrative employee performing the action.
     * @param contact The emergency contact to register.
     * @throws Exception if validation fails.
     */
    public void registerEmergencyContact(Employee admin, EmergencyContact contact) throws Exception {
        validateAdministrativeRole(admin);

        if (contact == null) {
            throw new Exception(ERROR_NULL_CONTACT);
        }

        contactPort.registerEmergencyContact(contact);
    }
}
