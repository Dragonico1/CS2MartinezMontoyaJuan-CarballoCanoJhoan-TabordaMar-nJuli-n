package app.domain.services.patient;

import app.domain.model.EmergencyContact;
import app.domain.ports.PatientPort;

/**
 *
 * @author Dragonico
 */
public class AssignEmergencyContact {
    private PatientPort patientPort;

    public AssignEmergencyContact(PatientPort patientPort) {
        this.patientPort = patientPort;
    }

    public void assign(String patientId, EmergencyContact contact) throws Exception {
        if (patientId == null || patientId.isEmpty()) {
            throw new Exception("El ID del paciente no puede estar vacío");
        }
        if (contact == null) {
            throw new Exception("El contacto de emergencia no puede ser nulo");
        }
        patientPort.assignEmergencyContact(patientId, contact);
    }
}
