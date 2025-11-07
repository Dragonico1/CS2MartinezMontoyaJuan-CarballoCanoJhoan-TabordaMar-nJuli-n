package app.adapter.rest.request;

import java.time.LocalDate;

/**
 * Request para registrar o actualizar pólizas médicas.
 * Usado por el módulo administrativo o de seguros.
 * 
 * @author Dragonico
 */
public class MedicalPolicyRequest {
    private String policyNumber;
    private String insureName;
    private boolean state;
    private LocalDate policyDuration;

    // Getters & Setters
    public String getPolicyNumber() { return policyNumber; }
    public void setPolicyNumber(String policyNumber) { this.policyNumber = policyNumber; }

    public String getInsureName() { return insureName; }
    public void setInsureName(String insureName) { this.insureName = insureName; }

    public boolean isState() { return state; }
    public void setState(boolean state) { this.state = state; }

    public LocalDate getPolicyDuration() { return policyDuration; }
    public void setPolicyDuration(LocalDate policyDuration) { this.policyDuration = policyDuration; }
}
