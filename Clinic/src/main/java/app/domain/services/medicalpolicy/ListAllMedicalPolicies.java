package app.domain.services.medicalpolicy;

import app.domain.model.MedicalPolicy;
import app.domain.ports.MedicalPolicyPort;
import java.util.List;

/**
 *
 * @author Dragonico
 */
public class ListAllMedicalPolicies {
    private final MedicalPolicyPort medicalPolicyPort;

    public ListAllMedicalPolicies(MedicalPolicyPort medicalPolicyPort) {
        this.medicalPolicyPort = medicalPolicyPort;
    }

    public List<MedicalPolicy> list() throws Exception {
        return medicalPolicyPort.listAllPolicies();
    }
}
