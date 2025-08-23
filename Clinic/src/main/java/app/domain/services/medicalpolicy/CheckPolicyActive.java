package app.domain.services.medicalpolicy;

import app.domain.ports.MedicalPolicyPort;

/**
 *
 * @author Dragonico
 */
public class CheckPolicyActive {
    private MedicalPolicyPort policyPort;

    public CheckPolicyActive(MedicalPolicyPort policyPort) {
        this.policyPort = policyPort;
    }

    public boolean execute(String policyId) throws Exception {
        if (policyId == null || policyId.isBlank())
            throw new Exception("El ID de la póliza no puede estar vacío");

        return policyPort.isPolicyActive(policyId);
    }
}
