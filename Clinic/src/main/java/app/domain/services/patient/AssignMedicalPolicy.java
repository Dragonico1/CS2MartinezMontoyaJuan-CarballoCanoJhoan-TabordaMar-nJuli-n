package app.domain.services.patient;

import app.domain.model.MedicalPolicy;
import app.domain.ports.PatientPort;

/**
 *
 * @author Dragonico
 */
public class AssignMedicalPolicy {
    private PatientPort patientPort;

    public AssignMedicalPolicy(PatientPort patientPort) {
        this.patientPort = patientPort;
    }

    public void assign(String patientId, MedicalPolicy policy) throws Exception {
        if (patientId == null || patientId.isEmpty()) {
            throw new Exception("El ID del paciente no puede estar vacío");
        }
        if (policy == null) {
            throw new Exception("La póliza no puede ser nula");
        }
        patientPort.assignMedicalPolicy(patientId, policy);
    }
}
