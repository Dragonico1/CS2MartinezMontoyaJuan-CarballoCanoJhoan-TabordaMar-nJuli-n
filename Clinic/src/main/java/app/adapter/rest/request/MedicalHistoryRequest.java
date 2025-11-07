package app.adapter.rest.request;

import java.time.LocalDate;

/**
 * Request para registrar o actualizar historias clínicas.
 * Usado por el controlador del médico.
 * 
 * @author Dragonico
 */
public class MedicalHistoryRequest {

    private LocalDate date;
    private String doctorId;
    private String patientId;
    private String reasonVisit;
    private String symptoms;
    private String diagnosis;

    // ---------- Getters & Setters ----------
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getReasonVisit() {
        return reasonVisit;
    }

    public void setReasonVisit(String reasonVisit) {
        this.reasonVisit = reasonVisit;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
}
