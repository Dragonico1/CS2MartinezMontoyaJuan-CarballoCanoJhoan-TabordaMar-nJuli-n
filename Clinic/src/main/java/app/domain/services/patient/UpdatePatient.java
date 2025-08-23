package app.domain.services.patient;

import app.domain.model.Patient;
import app.domain.ports.PatientPort;

/**
 *
 * @author Dragonico
 */
public class UpdatePatient {
    private PatientPort patientPort;

    public UpdatePatient(PatientPort patientPort) {
        this.patientPort = patientPort;
    }

    public void update(String patientId, Patient updatedData) throws Exception {
        if (patientId == null || patientId.isEmpty()) {
            throw new Exception("El ID del paciente no puede estar vacío");
        }
        if (updatedData == null) {
            throw new Exception("Los datos del paciente no pueden ser nulos");
        }
        patientPort.updatePatient(patientId, updatedData);
    }
}
