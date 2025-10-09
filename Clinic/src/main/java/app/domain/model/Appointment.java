package app.domain.model;

import java.time.LocalDateTime;
import app.domain.model.Emuns.AppointmentStatus;

/**
 * Representa una cita médica agendada por el personal administrativo.
 * @author Dragonico
 */
public class Appointment {
    private String appointmentId;
    private Patient patient;
    private Employee doctor;
    private LocalDateTime dateTime;
    private String reason;
    private AppointmentStatus status;

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        if (appointmentId == null || appointmentId.isBlank()) {
            throw new IllegalArgumentException("El ID de la cita no puede estar vacío");
        }
        this.appointmentId = appointmentId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        if (patient == null) {
            throw new IllegalArgumentException("El paciente no puede ser nulo");
        }
        this.patient = patient;
    }

    public Employee getDoctor() {
        return doctor;
    }

    public void setDoctor(Employee doctor) {
        if (doctor == null) {
            throw new IllegalArgumentException("El médico asignado no puede ser nulo");
        }
        this.doctor = doctor;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        if (dateTime == null || dateTime.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("La fecha de la cita no puede ser nula ni anterior a la actual");
        }
        this.dateTime = dateTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        if (reason == null || reason.isBlank()) {
            throw new IllegalArgumentException("Debe especificar el motivo de la cita");
        }
        this.reason = reason;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        if (status == null) {
            throw new IllegalArgumentException("El estado de la cita no puede ser nulo");
        }
        this.status = status;
    }
}
