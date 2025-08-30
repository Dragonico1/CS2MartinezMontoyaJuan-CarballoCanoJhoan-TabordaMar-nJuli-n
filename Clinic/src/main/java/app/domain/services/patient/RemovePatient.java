package app.domain.services.patient;

import app.domain.ports.PatientPort;

/**
 *
 * @author Dragonico
 */
public class RemovePatient {
    private final PatientPort patientPort;

    public RemovePatient(PatientPort patientPort) {
        this.patientPort = patientPort;
    }

    public void remove(String patientId) throws Exception {
        if (patientId == null || patientId.isEmpty()) throw new Exception("El ID del paciente no puede ser nulo");
        patientPort.removePatient(patientId);
    }
}
