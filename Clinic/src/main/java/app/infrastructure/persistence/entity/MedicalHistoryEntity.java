package app.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Entity for MedicalHistory table in the database.
 * Represents a patient's clinical record.
 * 
 * @author Dragonico
 */
@Entity
@Table(name = "medical_histories")
public class MedicalHistoryEntity {

    @Id
    @Column(name = "history_id", length = 10, nullable = false)
    private String historyId;

    @Column(name = "patient_id", length = 10, nullable = false)
    private String patientId;

    @Column(name = "doctor_id", length = 10, nullable = false)
    private String doctorId;

    @Column(name = "diagnosis", nullable = false, length = 255)
    private String diagnosis;

    @Column(name = "treatment", nullable = false, length = 255)
    private String treatment;

    @Column(name = "creation_date", nullable = false)
    private LocalDate creationDate;

    @Column(name = "observations", length = 255)
    private String observations;

    public MedicalHistoryEntity() {
    }

    public String getHistoryId() {
        return historyId;
    }

    public void setHistoryId(String historyId) {
        this.historyId = historyId;
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

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }
}
