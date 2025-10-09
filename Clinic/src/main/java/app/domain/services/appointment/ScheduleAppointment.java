package app.domain.services.appointment;

import app.domain.model.Appointment;
import app.domain.ports.AppointmentPort;

/**
 * Service for scheduling new medical appointments.
 * @author Dragonico
 */
public class ScheduleAppointment {
    private final AppointmentPort appointmentPort;

    public ScheduleAppointment(AppointmentPort appointmentPort) {
        this.appointmentPort = appointmentPort;
    }

    public void schedule(Appointment appointment) throws Exception {
        if (appointment == null) throw new Exception("La cita no puede ser nula");
        appointmentPort.scheduleAppointment(appointment);
    }
}
