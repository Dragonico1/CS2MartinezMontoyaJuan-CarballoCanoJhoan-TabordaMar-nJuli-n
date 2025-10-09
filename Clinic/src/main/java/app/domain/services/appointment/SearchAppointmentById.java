package app.domain.services.appointment;

import app.domain.model.Appointment;
import app.domain.ports.AppointmentPort;

/**
 * Service to search for an appointment by your ID.
 * @author Dragonico
 */
public class SearchAppointmentById {
    private final AppointmentPort appointmentPort;

    public SearchAppointmentById(AppointmentPort appointmentPort) {
        this.appointmentPort = appointmentPort;
    }

    public Appointment search(String appointmentId) throws Exception {
        if (appointmentId == null || appointmentId.isBlank()) 
            throw new Exception("El ID de la cita no puede estar vacío");
        return appointmentPort.searchAppointmentById(appointmentId);
    }
}
