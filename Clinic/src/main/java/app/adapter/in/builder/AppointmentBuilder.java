package app.adapter.in.builder;

import org.springframework.stereotype.Component;
import app.adapter.rest.request.AppointmentRequest; // ✅ usa el mismo DTO que el controlador
import app.domain.model.Appointment;
import app.domain.model.Employee;
import app.domain.model.Patient;
import app.domain.model.Emuns.AppointmentStatus;

@Component
public class AppointmentBuilder {

    public Appointment build(AppointmentRequest request) throws Exception {
        if (request == null) {
            throw new Exception("La solicitud de cita no puede ser nula.");
        }

        Appointment appointment = new Appointment();
        appointment.setAppointmentId(request.getAppointmentId());
        appointment.setDateTime(request.getDateTime());
        appointment.setReason(request.getReason());

        // Estado
        if (request.getStatus() != null) {
            appointment.setStatus(AppointmentStatus.valueOf(request.getStatus().toUpperCase()));
        } else {
            appointment.setStatus(AppointmentStatus.PENDING);
        }

        // Asignar paciente
        if (request.getPatientId() != null) {
            Patient patient = new Patient();
            patient.setId(request.getPatientId());
            appointment.setPatient(patient);
        }

        // Asignar doctor
        if (request.getDoctorId() != null) {
            Employee doctor = new Employee();
            doctor.setId(request.getDoctorId());
            appointment.setDoctor(doctor);
        }

        return appointment;
    }
}
