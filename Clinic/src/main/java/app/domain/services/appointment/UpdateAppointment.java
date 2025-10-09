package app.domain.services.appointment;

import app.domain.model.Appointment;
import app.domain.ports.AppointmentPort;

/**
 * Service to update an existing appointment.
 * @author Dragonico
 */
public class UpdateAppointment {
    private final AppointmentPort appointmentPort;

    public UpdateAppointment(AppointmentPort appointmentPort) {
        this.appointmentPort = appointmentPort;
    }

    public void update(String appointmentId, Appointment updatedData) throws Exception {
        if (appointmentId == null || appointmentId.isBlank()) 
            throw new Exception("El ID de la cita no puede estar vacío");
        if (updatedData == null) 
            throw new Exception("Los datos de la cita no pueden ser nulos");
        appointmentPort.updateAppointment(appointmentId, updatedData);
    }
}
