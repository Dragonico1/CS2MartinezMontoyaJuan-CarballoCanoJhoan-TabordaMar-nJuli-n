package app.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Entity for MedicalPolicy table in the database.
 * Represents an insurance policy assigned to a patient.
 * 
 * @author Dragonico
 */
@Entity
@Table(name = "medical_policies")
public class MedicalPolicyEntity {
    
    @Id
    @Column(name = "policy_number", length = 30, nullable = false, unique = true)
    private String policyNumber;
    
    @Column(name = "insure_name", nullable = false)
    private String insureName;
    
    @Column(name = "state", nullable = false)
    private boolean state;
    
    @Column(name = "policy_duration", nullable = false)
    private LocalDate policyDuration;

    public MedicalPolicyEntity() {
    }

    // ---------------- Getters & Setters ----------------

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getInsureName() {
        return insureName;
    }

    public void setInsureName(String insureName) {
        this.insureName = insureName;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public LocalDate getPolicyDuration() {
        return policyDuration;
    }

    public void setPolicyDuration(LocalDate policyDuration) {
        this.policyDuration = policyDuration;
    }
}
