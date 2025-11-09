package app.domain.ports;

import app.domain.model.EmergencyContact;
import java.util.List;

/**
 *
 * @author Dragonico
 */
public interface EmergencyContactPort {
    void registerEmergencyContact(EmergencyContact contact) throws Exception;
    void updateEmergencyContact(long contactId, EmergencyContact updatedData) throws Exception;
    void removeEmergencyContact(String contactId) throws Exception;
    EmergencyContact searchEmergencyContactById(long contactId) throws Exception;
    List<EmergencyContact> listAllEmergencyContacts() throws Exception;
    void assignEmergencyContact(String patientId, EmergencyContact contact) throws Exception;
}
