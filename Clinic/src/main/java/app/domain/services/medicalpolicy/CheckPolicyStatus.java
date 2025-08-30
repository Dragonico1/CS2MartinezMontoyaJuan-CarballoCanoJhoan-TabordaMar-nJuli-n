package app.domain.services.medicalpolicy;

import app.domain.ports.MedicalPolicyPort;

/**
 *
 * @author Dragonico
 */
public class CheckPolicyStatus {
    private final MedicalPolicyPort medicalPolicyPort;

    public CheckPolicyStatus(MedicalPolicyPort medicalPolicyPort) {
        this.medicalPolicyPort = medicalPolicyPort;
    }

    public boolean isActive(String policyId) throws Exception {
        if (policyId == null || policyId.isEmpty()) throw new Exception("El ID de la póliza no puede ser nulo");
        return medicalPolicyPort.isPolicyActive(policyId);
    }
}
