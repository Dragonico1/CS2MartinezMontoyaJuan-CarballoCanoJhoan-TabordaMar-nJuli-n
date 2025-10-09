package app.domain.services.appointment;

import app.domain.ports.AppointmentPort;

/**
 * Service to cancel a medical appointment.
 * @author Dragonico
 */
public class CancelAppointment {
    private final AppointmentPort appointmentPort;

    public CancelAppointment(AppointmentPort appointmentPort) {
        this.appointmentPort = appointmentPort;
    }

    public void cancel(String appointmentId) throws Exception {
        if (appointmentId == null || appointmentId.isBlank()) 
            throw new Exception("El ID de la cita no puede estar vacío");
        appointmentPort.cancelAppointment(appointmentId);
    }
}
