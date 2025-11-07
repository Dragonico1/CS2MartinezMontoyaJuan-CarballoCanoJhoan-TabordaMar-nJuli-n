package app.adapter.rest.response;

/**
 * Response para mostrar la información de una póliza médica.
 * Devuelve los datos principales registrados en el sistema.
 * 
 * @author Dragonico
 */
public class MedicalPolicyResponse {

    private String policyNumber;
    private String insureName;
    private boolean state;
    private int policyDuration;

    // ---------- Getters & Setters ----------
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

    public int getPolicyDuration() {
        return policyDuration;
    }

    public void setPolicyDuration(int policyDuration) {
        this.policyDuration = policyDuration;
    }
}
