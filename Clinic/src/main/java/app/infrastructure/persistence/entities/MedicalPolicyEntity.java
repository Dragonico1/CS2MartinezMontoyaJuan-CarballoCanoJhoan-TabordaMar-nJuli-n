package app.infrastructure.persistence.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Entity for MedicalPolicy table in database
 * @author Dragonico
 */
@Entity
@Table(name = "medical_policies")
public class MedicalPolicyEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "policy_id")
    private Long policyId;
    
    @Column(name = "insure_name", nullable = false)
    private String insureName;
    
    @Column(name = "policy_number", nullable = false)
    private double policyNumber;
    
    @Column(name = "state", nullable = false)
    private boolean state;
    
    @Column(name = "policy_duration", nullable = false)
    private LocalDate policyDuration;

    public MedicalPolicyEntity() {
    }

    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }

    public String getInsureName() {
        return insureName;
    }

    public void setInsureName(String insureName) {
        this.insureName = insureName;
    }

    public double getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(double policyNumber) {
        this.policyNumber = policyNumber;
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