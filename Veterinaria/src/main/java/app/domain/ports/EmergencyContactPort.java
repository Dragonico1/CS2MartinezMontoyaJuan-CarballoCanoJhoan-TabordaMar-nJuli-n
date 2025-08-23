package app.domain.ports;

import app.domain.model.EmergencyContact;

/**
 *
 * @author Dragonico
 */
public interface EmergencyContactPort {
    void assignEmergencyContact(String patientId, EmergencyContact contact);
    
}
