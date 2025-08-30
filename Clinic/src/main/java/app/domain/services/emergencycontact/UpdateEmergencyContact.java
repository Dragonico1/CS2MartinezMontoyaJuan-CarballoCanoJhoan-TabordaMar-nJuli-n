package app.domain.services.emergencycontact;

import app.domain.model.EmergencyContact;
import app.domain.ports.EmergencyContactPort;

/**
 *
 * @author Dragonico
 */
public class UpdateEmergencyContact {
    private final EmergencyContactPort emergencyContactPort;

    public UpdateEmergencyContact(EmergencyContactPort emergencyContactPort) {
        this.emergencyContactPort = emergencyContactPort;
    }

    public void update(String contactId, EmergencyContact updatedData) throws Exception {
        if (contactId == null || contactId.isEmpty()) throw new Exception("El ID del contacto no puede ser nulo");
        if (updatedData == null) throw new Exception("Los datos actualizados no pueden ser nulos");
        emergencyContactPort.updateEmergencyContact(contactId, updatedData);
    }
}
