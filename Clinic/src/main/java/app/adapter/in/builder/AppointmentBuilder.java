package app.adapter.in.builder;

import org.springframework.stereotype.Component;
import app.adapter.in.rest.request.AppointmentRequest;
import app.domain.model.Appointment;
import app.domain.model.Patient;
import app.domain.model.Employee;
import app.domain.model.Emuns.AppointmentStatus;

@Component
public class AppointmentBuilder {

    /**
     * Build Appointment domain object from AppointmentRequest.
     * It creates lightweight Patient and Employee objects containing only the id.
     * The persistence layer can later resolve full objects if needed.
     *
     */
    public Appointment build(AppointmentRequest request) throws Exception {
        if (request == null) {
            throw new Exception("La solicitud de cita no puede ser nula.");
        }

        // Validate required ids
        if (request.getPatientId() == null || request.getPatientId().isBlank()) {
            throw new Exception("El ID del paciente es obligatorio.");
        }
        if (request.getDoctorId() == null || request.getDoctorId().isBlank()) {
            throw new Exception("El ID del médico es obligatorio.");
        }
        if (request.getAppointmentDate() == null) {
            throw new Exception("La fecha y hora de la cita son obligatorias.");
        }
        if (request.getReason() == null || request.getReason().isBlank()) {
            throw new Exception("Debe especificar el motivo de la cita.");
        }

        Appointment appointment = new Appointment();

        // id
        if (request.getAppointmentId() != null && !request.getAppointmentId().isBlank()) {
            appointment.setAppointmentId(request.getAppointmentId());
        }

        // patient (stub with id)
        Patient patient = new Patient();
        patient.setId(request.getPatientId());
        appointment.setPatient(patient);

        // doctor (stub with id)
        Employee doctor = new Employee();
        doctor.setId(request.getDoctorId());
        appointment.setDoctor(doctor);

        // date/time (Appointment.setDateTime validates not in past)
        appointment.setDateTime(request.getAppointmentDate());

        // reason
        appointment.setReason(request.getReason());

        // status: accept Spanish enum names (PENDIENTE, COMPLETADA, CANCELADA)
        // and also map common English names for convenience.
        String rawStatus = request.getStatus();
        if (rawStatus == null || rawStatus.isBlank()) {
            appointment.setStatus(AppointmentStatus.PENDIENTE);
        } else {
            String s = rawStatus.trim().toUpperCase();
            if ("SCHEDULED".equals(s)) s = "PENDIENTE";
            else if ("COMPLETED".equals(s)) s = "COMPLETADA";
            else if ("CANCELLED".equals(s) || "CANCELED".equals(s)) s = "CANCELADA";

            try {
                AppointmentStatus status = AppointmentStatus.valueOf(s);
                appointment.setStatus(status);
            } catch (IllegalArgumentException ex) {
                throw new Exception("Estado de cita inválido. Valores válidos: PENDIENTE, COMPLETADA, CANCELADA");
            }
        }

        return appointment;
    }
}
