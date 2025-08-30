package app.domain.services.emergencycontact;

import app.domain.model.EmergencyContact;
import app.domain.ports.EmergencyContactPort;
import java.util.List;

/**
 *
 * @author Dragonico
 */
public class ListAllEmergencyContacts {
    private final EmergencyContactPort emergencyContactPort;

    public ListAllEmergencyContacts(EmergencyContactPort emergencyContactPort) {
        this.emergencyContactPort = emergencyContactPort;
    }

    public List<EmergencyContact> list() throws Exception {
        return emergencyContactPort.listAllEmergencyContacts();
    }
}
