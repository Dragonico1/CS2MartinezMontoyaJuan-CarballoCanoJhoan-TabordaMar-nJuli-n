package app.application.usecases;

import app.domain.model.*;
import app.domain.model.Emuns.Role;
import app.domain.ports.*;
import app.adapter.in.validators.AppointmentValidator;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Main use case class for the Administrative Staff (AdminStaff) role.
 * Handles management of patients, appointments, billing, and emergency contacts.
 * 
 * @author Dragonico
 */

@Service
public class AdministrativeUseCase {

    // --------------------- CONSTANT MESSAGES ---------------------
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
    private void validateAdministrativeRole(Employee employee) throws Exception {
        if (employee == null || employee.getRole() != Role.ADMIN_STAFF) {
            throw new Exception(ERROR_UNAUTHORIZED);
        }
    }

    // --------------------- PATIENT MANAGEMENT ---------------------
    public void registerPatient(Employee admin, Patient patient) throws Exception {
        validateAdministrativeRole(admin);
        if (patient == null) throw new Exception(ERROR_NULL_PATIENT);
        patientPort.registerPatient(patient);
    }

    public void updatePatient(Employee admin, String patientId, Patient updatedPatient) throws Exception {
        validateAdministrativeRole(admin);
        if (patientId == null || patientId.isBlank()) throw new Exception(ERROR_EMPTY_PATIENT_ID);
        if (updatedPatient == null) throw new Exception(ERROR_NULL_PATIENT_DATA);
        patientPort.updatePatient(patientId, updatedPatient);
    }

    // --------------------- PATIENT QUERIES ---------------------
    public Patient searchPatient(Employee admin, String patientId) throws Exception {
        validateAdministrativeRole(admin);
        if (patientId == null || patientId.isBlank()) throw new Exception(ERROR_EMPTY_PATIENT_ID);
        Patient patient = patientPort.searchPatientById(patientId);
        if (patient == null) throw new Exception("No se encontró un paciente con el ID: " + patientId);
        return patient;
    }

    public List<Patient> listAllPatients(Employee admin) throws Exception {
        validateAdministrativeRole(admin);
        return patientPort.listAllPatients();
    }

    // --------------------- APPOINTMENT MANAGEMENT ---------------------
    public void createAppointment(Employee admin, Appointment appointment) throws Exception {
        validateAdministrativeRole(admin);
        if (appointment == null) throw new Exception(ERROR_NULL_APPOINTMENT);
        appointmentValidator.validate(appointment);
        appointmentPort.scheduleAppointment(appointment);
    }

    public void updateAppointment(Employee admin, String appointmentId, Appointment updatedAppointment) throws Exception {
        validateAdministrativeRole(admin);
        if (appointmentId == null || appointmentId.isBlank()) throw new Exception(ERROR_EMPTY_APPOINTMENT_ID);
        if (updatedAppointment == null) throw new Exception(ERROR_NULL_APPOINTMENT_DATA);
        appointmentValidator.validate(updatedAppointment);
        appointmentPort.updateAppointment(appointmentId, updatedAppointment);
    }

    // --------------------- BILLING MANAGEMENT ---------------------
    public void generateBill(Employee admin, Billing bill) throws Exception {
        validateAdministrativeRole(admin);
        if (bill == null) throw new Exception(ERROR_NULL_BILL);
        billingPort.generateBill(bill);
    }

    // --------------------- EMERGENCY CONTACT MANAGEMENT ---------------------
    public void registerEmergencyContact(Employee admin, EmergencyContact contact) throws Exception {
        validateAdministrativeRole(admin);
        if (contact == null) throw new Exception(ERROR_NULL_CONTACT);
        contactPort.registerEmergencyContact(contact);
    }

    public void updateEmergencyContact(Employee admin, EmergencyContact contact) throws Exception {
        validateAdministrativeRole(admin);
        if (contact == null) throw new Exception(ERROR_NULL_CONTACT);
        contactPort.updateEmergencyContact(contact.getId(), contact);
    }

    public EmergencyContact searchEmergencyContactById(Employee admin, Long contactId) throws Exception {
        validateAdministrativeRole(admin);
        return contactPort.searchEmergencyContactById(contactId);
    }

    public List<EmergencyContact> listAllEmergencyContacts(Employee admin) throws Exception {
        validateAdministrativeRole(admin);
        return contactPort.listAllEmergencyContacts();
    }
}
