package app.domain.services.emergencycontact;

import app.domain.ports.EmergencyContactPort;

/**
 *
 * @author Dragonico
 */
public class RemoveEmergencyContact {
    private final EmergencyContactPort emergencyContactPort;

    public RemoveEmergencyContact(EmergencyContactPort emergencyContactPort) {
        this.emergencyContactPort = emergencyContactPort;
    }

    public void remove(String contactId) throws Exception {
        if (contactId == null || contactId.isEmpty()) throw new Exception("El ID del contacto no puede ser nulo");
        emergencyContactPort.removeEmergencyContact(contactId);
    }
}
