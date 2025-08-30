package app.domain.services.medicalpolicy;

import app.domain.ports.MedicalPolicyPort;

/**
 *
 * @author Dragonico
 */
public class RemoveMedicalPolicy {
    private final MedicalPolicyPort medicalPolicyPort;

    public RemoveMedicalPolicy(MedicalPolicyPort medicalPolicyPort) {
        this.medicalPolicyPort = medicalPolicyPort;
    }

    public void remove(String policyId) throws Exception {
        if (policyId == null || policyId.isEmpty()) throw new Exception("El ID de la póliza no puede ser nulo");
        medicalPolicyPort.removeMedicalPolicy(policyId);
    }
}
