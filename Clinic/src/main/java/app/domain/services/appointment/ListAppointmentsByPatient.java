package app.domain.services.appointment;

import app.domain.model.Appointment;
import app.domain.ports.AppointmentPort;
import java.util.List;

/**
 * Service to list a patient's appointments.
 * @author Dragonico
 */
public class ListAppointmentsByPatient {
    private final AppointmentPort appointmentPort;

    public ListAppointmentsByPatient(AppointmentPort appointmentPort) {
        this.appointmentPort = appointmentPort;
    }

    public List<Appointment> list(String patientId) throws Exception {
        if (patientId == null || patientId.isBlank()) 
            throw new Exception("El ID del paciente no puede estar vacío");
        return appointmentPort.listAppointmentsByPatient(patientId);
    }
}
