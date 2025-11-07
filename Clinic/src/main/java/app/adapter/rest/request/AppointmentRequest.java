package app.adapter.rest.request;

import java.time.LocalDateTime;

/**
 * Request para crear o actualizar citas médicas.
 * Usado por controladores de tipo administrativo o médico.
 * 
 * @author Dragonico
 */
public class AppointmentRequest {
    private String appointmentId;
    private String patientId;
    private String doctorId;
    private LocalDateTime dateTime;
    private String reason;
    private String status;

    // Getters & Setters
    public String getAppointmentId() { return appointmentId; }
    public void setAppointmentId(String appointmentId) { this.appointmentId = appointmentId; }

    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }

    public String getDoctorId() { return doctorId; }
    public void setDoctorId(String doctorId) { this.doctorId = doctorId; }

    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
