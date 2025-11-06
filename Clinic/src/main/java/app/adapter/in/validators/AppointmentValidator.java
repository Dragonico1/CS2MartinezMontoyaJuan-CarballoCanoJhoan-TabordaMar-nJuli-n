package app.adapter.in.validators;

import app.domain.model.Appointment;
import app.domain.model.Emuns.AppointmentStatus;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

/**
 * Validador para los campos del modelo Appointment.
 * @author Dragonico
 */
@Component
public class AppointmentValidator extends SimpleValidator {

    public String appointmentIdValidator(String value) throws Exception {
        stringValidator("ID de la cita", value);
        if (!value.matches("\\d+")) {
            throw new Exception("El ID de la cita debe ser numérico");
        }
        if (value.length() > 6) {
            throw new Exception("El ID de la cita no puede superar los 6 dígitos");
        }
        return value;
    }

    public Object patientValidator(Object patient) throws Exception {
        if (patient == null) {
            throw new Exception("Debe seleccionar un paciente para la cita");
        }
        return patient;
    }

    public Object doctorValidator(Object doctor) throws Exception {
        if (doctor == null) {
            throw new Exception("Debe asignar un médico a la cita");
        }
        return doctor;
    }

    public LocalDateTime dateTimeValidator(LocalDateTime value) throws Exception {
        if (value == null) {
            throw new Exception("La fecha y hora de la cita no pueden ser nulas");
        }
        if (value.isBefore(LocalDateTime.now())) {
            throw new Exception("La cita no puede programarse en una fecha pasada");
        }
        return value;
    }

    public String reasonValidator(String value) throws Exception {
        return stringValidator("motivo de la cita", value);
    }

    public AppointmentStatus statusValidator(AppointmentStatus status) throws Exception {
        if (status == null) {
            throw new Exception("El estado de la cita no puede ser nulo");
        }
        return status;
    }

    public void validate(Appointment appointment) throws Exception {
        if (appointment == null)
            throw new Exception("El objeto cita no puede ser nulo");

        appointmentIdValidator(appointment.getAppointmentId());
        patientValidator(appointment.getPatient());
        doctorValidator(appointment.getDoctor());
        dateTimeValidator(appointment.getDateTime());
        reasonValidator(appointment.getReason());
        statusValidator(appointment.getStatus());
    }
}
