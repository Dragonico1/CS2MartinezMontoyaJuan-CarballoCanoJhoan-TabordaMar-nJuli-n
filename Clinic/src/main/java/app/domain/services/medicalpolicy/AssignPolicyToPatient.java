package app.domain.services.medicalpolicy;

import app.domain.model.MedicalPolicy;
import app.domain.ports.MedicalPolicyPort;

/**
 *
 * @author Dragonico
 */
public class AssignPolicyToPatient {
    private MedicalPolicyPort policyPort;

    public AssignPolicyToPatient(MedicalPolicyPort policyPort) {
        this.policyPort = policyPort;
    }

    public void assign(String patientId, MedicalPolicy policy) throws Exception {
        if (patientId == null || patientId.isBlank())
            throw new Exception("El ID del paciente no puede estar vacío");
        if (policy == null)
            throw new Exception("La póliza médica no puede ser nula");

        policyPort.assignPolicyToPatient(patientId, policy);
    }
}
