package app.domain.services.emergencycontact;

import app.domain.model.EmergencyContact;
import app.domain.ports.EmergencyContactPort;

/**
 *
 * @author Dragonico
 */
public class SearchEmergencyContactById {
    private final EmergencyContactPort emergencyContactPort;

    public SearchEmergencyContactById(EmergencyContactPort emergencyContactPort) {
        this.emergencyContactPort = emergencyContactPort;
    }

    public EmergencyContact search(String contactId) throws Exception {
        if (contactId == null || contactId.isEmpty()) throw new Exception("El ID del contacto no puede ser nulo");
        return emergencyContactPort.searchEmergencyContactById(contactId);
    }
}
