package app.domain.model;

import java.time.LocalDate;

/**
 *
 * @author Dragonico
 */
public class MedicalHistory {
    private LocalDate Date;
    private Employee Doctor;
    private String ReasonVisit;
    private String Symptoms;
    private Diagnosis diagnosis;

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

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }
    
}
