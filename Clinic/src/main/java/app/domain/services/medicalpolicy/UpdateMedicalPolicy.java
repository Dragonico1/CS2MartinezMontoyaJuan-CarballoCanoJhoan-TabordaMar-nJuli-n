package app.domain.services.medicalpolicy;

import app.domain.model.MedicalPolicy;
import app.domain.ports.MedicalPolicyPort;

/**
 *
 * @author Dragonico
 */
public class UpdateMedicalPolicy {
    private final MedicalPolicyPort medicalPolicyPort;

    public UpdateMedicalPolicy(MedicalPolicyPort medicalPolicyPort) {
        this.medicalPolicyPort = medicalPolicyPort;
    }

    public void update(String policyId, MedicalPolicy updatedData) throws Exception {
        if (policyId == null || policyId.isEmpty()) throw new Exception("El ID de la póliza no puede ser nulo");
        if (updatedData == null) throw new Exception("Los datos actualizados no pueden ser nulos");
        medicalPolicyPort.updateMedicalPolicy(policyId, updatedData);
    }
}
