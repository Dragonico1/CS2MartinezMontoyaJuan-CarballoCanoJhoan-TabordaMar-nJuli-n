package app.domain.ports;

import app.domain.model.Appointment;
import java.util.List;

/**
 * Define las operaciones de gestión de citas médicas.
 * Implementa la conexión entre la capa de dominio y la infraestructura (repositorios).
 * 
 * @author Dragonico
 */
public interface AppointmentPort {
    void scheduleAppointment(Appointment appointment) throws Exception;
    void updateAppointment(String appointmentId, Appointment updatedData) throws Exception;
    void cancelAppointment(String appointmentId) throws Exception;
    Appointment searchAppointmentById(String appointmentId) throws Exception;
    List<Appointment> listAllAppointments() throws Exception;
    List<Appointment> listAppointmentsByPatient(String patientId) throws Exception;
}
