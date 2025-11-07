package app.adapter.rest.mapper;

import org.springframework.stereotype.Component;
import app.adapter.rest.request.AppointmentRequest;
import app.adapter.rest.response.AppointmentResponse;
import app.domain.model.Appointment;
import app.domain.model.Employee;
import app.domain.model.Patient;
import app.domain.model.Emuns.AppointmentStatus;

@Component
public class AppointmentRestMapper {

    // -------------------- Request → Domain --------------------
    public Appointment toDomain(AppointmentRequest request) {
        if (request == null) return null;

        Appointment appointment = new Appointment();

        appointment.setAppointmentId(request.getAppointmentId());
        appointment.setDateTime(request.getDateTime());
        appointment.setReason(request.getReason());

        // Estado
        if (request.getStatus() != null) {
            try {
                appointment.setStatus(AppointmentStatus.valueOf(request.getStatus().toUpperCase()));
            } catch (IllegalArgumentException e) {
                appointment.setStatus(AppointmentStatus.PENDING);
            }
        } else {
            appointment.setStatus(AppointmentStatus.PENDING);
        }

        // Paciente
        if (request.getPatientId() != null) {
            Patient patient = new Patient();
            patient.setId(request.getPatientId());
            appointment.setPatient(patient);
        }

        // Doctor
        if (request.getDoctorId() != null) {
            Employee doctor = new Employee();
            doctor.setId(request.getDoctorId());
            appointment.setDoctor(doctor);
        }

        return appointment;
    }

    // -------------------- Domain → Response --------------------
    public AppointmentResponse toResponse(Appointment appointment) {
        if (appointment == null) return null;

        AppointmentResponse response = new AppointmentResponse();

        response.setAppointmentId(appointment.getAppointmentId());
        response.setDateTime(appointment.getDateTime());
        response.setReason(appointment.getReason());
        response.setStatus(
            appointment.getStatus() != null ? appointment.getStatus().name() : "PENDIENTE"
        );

        response.setPatientId(
            appointment.getPatient() != null ? appointment.getPatient().getID() : null
        );
        response.setDoctorId(
            appointment.getDoctor() != null ? appointment.getDoctor().getID() : null
        );

        return response;
    }
}
