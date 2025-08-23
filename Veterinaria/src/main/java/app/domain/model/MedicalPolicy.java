package app.domain.model;

import java.time.LocalDate;

/**
 *
 * @author Dragonico
 */
public class MedicalPolicy {
    private String InsureName;
    private double PolicyNumber;
    private boolean State;
    private LocalDate PolicyDuration;

    public String getInsureName() {
        return InsureName;
    }

    public void setInsureName(String InsureName) {
        this.InsureName = InsureName;
    }

    public double getPolicyNumber() {
        return PolicyNumber;
    }

    public void setPolicyNumber(double PolicyNumber) {
        this.PolicyNumber = PolicyNumber;
    }

    public boolean isState() {
        return State;
    }

    public void setState(boolean State) {
        this.State = State;
    }

    public LocalDate getPolicyDuration() {
        return PolicyDuration;
    }

    public void setPolicyDuration(LocalDate PolicyDuration) {
        this.PolicyDuration = PolicyDuration;
    }
    
}
