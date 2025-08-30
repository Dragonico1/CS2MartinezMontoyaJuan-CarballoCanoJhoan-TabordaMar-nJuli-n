package app.domain.services.patient;

import app.domain.model.Patient;
import app.domain.ports.PatientPort;

/**
 *
 * @author Dragonico
 */
public class SearchPatientById {
    private final PatientPort patientPort;

    public SearchPatientById(PatientPort patientPort) {
        this.patientPort = patientPort;
    }

    public Patient search(String patientId) throws Exception {
        if (patientId == null || patientId.isEmpty()) throw new Exception("El ID del paciente no puede ser nulo");
        return patientPort.searchPatientById(patientId);
    }
}
