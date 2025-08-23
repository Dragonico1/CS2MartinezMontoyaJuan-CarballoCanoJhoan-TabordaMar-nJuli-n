package app.domain.model;

import java.util.List;

/**
 *
 * @author Dragonico
 */
public class Diagnosis {
    private String consultationReason;
    private String symptoms;
    private String description;
    private List<Order> orders;

    public String getConsultationReason() {
        return consultationReason;
    }

    public void setConsultationReason(String consultationReason) {
        this.consultationReason = consultationReason;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
