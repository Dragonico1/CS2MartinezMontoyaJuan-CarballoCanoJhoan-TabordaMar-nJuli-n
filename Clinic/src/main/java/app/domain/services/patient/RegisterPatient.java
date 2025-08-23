package app.domain.services.patient;

import app.domain.model.Patient;
import app.domain.ports.PatientPort;

/**
 *
 * @author Dragonico
 */
public class RegisterPatient {
    private PatientPort patientPort;

    public RegisterPatient(PatientPort patientPort) {
        this.patientPort = patientPort;
    }

    public void register(Patient patient) throws Exception {
        if (patient == null) {
            throw new Exception("El paciente no puede ser nulo");
        }
        patientPort.registerPatient(patient);
    }
}

