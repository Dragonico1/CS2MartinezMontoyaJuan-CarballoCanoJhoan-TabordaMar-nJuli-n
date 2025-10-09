package app.domain.ports;

import app.domain.model.Appointment;
import java.util.List;

/**
 * Define operations to manage medical appointments..
 * @author Dragonico
 */
public interface AppointmentPort {
    void scheduleAppointment(Appointment appointment) throws Exception;
    void updateAppointment(String appointmentId, Appointment updatedData) throws Exception;
    void cancelAppointment(String appointmentId) throws Exception;
    Appointment searchAppointmentById(String appointmentId) throws Exception;
    List<Appointment> listAppointmentsByPatient(String patientId) throws Exception;
}
