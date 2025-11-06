package app.domain.model;

import java.time.LocalDate;

/**
 *
 * @author Dragonico
 */
public class MedicalHistory {
    private LocalDate Date;
    private Employee Doctor;
    private Patient patient;
    private String ReasonVisit;
    private String Symptoms;
    private String diagnosis;

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate Date) {
        this.Date = Date;
    }

    public Employee getDoctor() {
        return Doctor;
    }

    public void setDoctor(Employee Doctor) {
        this.Doctor = Doctor;
    }
    
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        if (patient == null) {
            throw new IllegalArgumentException("La historia clínica debe pertenecer a un paciente.");
        }
        this.patient = patient;
    }

    public String getReasonVisit() {
        return ReasonVisit;
    }

    public void setReasonVisit(String ReasonVisit) {
        this.ReasonVisit = ReasonVisit;
    }

    public String getSymptoms() {
        return Symptoms;
    }

    public void setSymptoms(String Symptoms) {
        this.Symptoms = Symptoms;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
    
}
