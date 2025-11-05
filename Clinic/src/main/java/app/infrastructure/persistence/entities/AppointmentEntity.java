package app.infrastructure.persistence.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entity for Appointment table in database
 * @author Dragonico
 */
@Entity
@Table(name = "appointments")
public class AppointmentEntity {
    
    @Id
    @Column(name = "appointment_id", nullable = false)
    private String appointmentId;
    
    @Column(name = "patient_id", length = 10, nullable = false)
    private String patientId;
    
    @Column(name = "doctor_id", length = 10, nullable = false)
    private String doctorId;
    
    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;
    
    @Column(name = "reason", nullable = false)
    private String reason;
    
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private AppointmentStatusEntity status;

    public AppointmentEntity() {
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public AppointmentStatusEntity getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatusEntity status) {
        this.status = status;
    }
}