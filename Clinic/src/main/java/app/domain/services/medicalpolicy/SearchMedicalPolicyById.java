package app.domain.services.medicalpolicy;

import app.domain.model.MedicalPolicy;
import app.domain.ports.MedicalPolicyPort;

/**
 *
 * @author Dragonico
 */
public class SearchMedicalPolicyById {
    private final MedicalPolicyPort medicalPolicyPort;

    public SearchMedicalPolicyById(MedicalPolicyPort medicalPolicyPort) {
        this.medicalPolicyPort = medicalPolicyPort;
    }

    public MedicalPolicy search(String policyId) throws Exception {
        if (policyId == null || policyId.isEmpty()) throw new Exception("El ID de la póliza no puede ser nulo");
        return medicalPolicyPort.searchMedicalPolicyById(policyId);
    }
}
