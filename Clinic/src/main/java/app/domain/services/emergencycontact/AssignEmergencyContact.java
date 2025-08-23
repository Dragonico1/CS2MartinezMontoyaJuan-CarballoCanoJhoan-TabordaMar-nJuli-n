package app.domain.services.emergencycontact;

import app.domain.model.EmergencyContact;
import app.domain.ports.EmergencyContactPort;

/**
 *
 * @author Dragonico
 */
public class AssignEmergencyContact {

    private EmergencyContactPort contactPort;

    public AssignEmergencyContact(EmergencyContactPort contactPort) {
        this.contactPort = contactPort;
    }

    public void assign(String patientId, EmergencyContact contact) throws Exception {
        if (patientId == null || patientId.isBlank())
            throw new Exception("El ID del paciente no puede estar vacío");
        if (contact == null)
            throw new Exception("El contacto de emergencia no puede ser nulo");

        contactPort.assignEmergencyContact(patientId, contact);
    }
}
