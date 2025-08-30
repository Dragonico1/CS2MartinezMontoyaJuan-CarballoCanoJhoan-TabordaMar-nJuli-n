package app.domain.ports;

import app.domain.model.EmergencyContact;
import java.util.List;

/**
 *
 * @author Dragonico
 */
public interface EmergencyContactPort {
    void registerEmergencyContact(EmergencyContact contact) throws Exception;
    void updateEmergencyContact(String contactId, EmergencyContact updatedData) throws Exception;
    void removeEmergencyContact(String contactId) throws Exception;
    EmergencyContact searchEmergencyContactById(String contactId) throws Exception;
    List<EmergencyContact> listAllEmergencyContacts() throws Exception;
    void assignEmergencyContact(String patientId, EmergencyContact contact) throws Exception;
}
