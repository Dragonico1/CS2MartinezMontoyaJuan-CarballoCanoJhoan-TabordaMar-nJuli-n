package app.domain.services.medicalpolicy;

import app.domain.model.MedicalPolicy;
import app.domain.ports.MedicalPolicyPort;

/**
 *
 * @author Dragonico
 */
public class RegisterMedicalPolicy {
    private final MedicalPolicyPort medicalPolicyPort;

    public RegisterMedicalPolicy(MedicalPolicyPort medicalPolicyPort) {
        this.medicalPolicyPort = medicalPolicyPort;
    }

    public void register(MedicalPolicy policy) throws Exception {
        if (policy == null) throw new Exception("La póliza médica no puede ser nula");
        medicalPolicyPort.registerMedicalPolicy(policy);
    }
}
