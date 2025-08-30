package app.domain.services.emergencycontact;

import app.domain.model.EmergencyContact;
import app.domain.ports.EmergencyContactPort;

/**
 *
 * @author Dragonico
 */
public class RegisterEmergencyContact {
    private final EmergencyContactPort emergencyContactPort;

    public RegisterEmergencyContact(EmergencyContactPort emergencyContactPort) {
        this.emergencyContactPort = emergencyContactPort;
    }

    public void register(EmergencyContact contact) throws Exception {
        if (contact == null) throw new Exception("El contacto de emergencia no puede ser nulo");
        emergencyContactPort.registerEmergencyContact(contact);
    }
}
