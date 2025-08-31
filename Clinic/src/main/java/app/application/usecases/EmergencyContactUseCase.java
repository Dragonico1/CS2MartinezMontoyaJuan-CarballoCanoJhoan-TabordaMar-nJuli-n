package app.application.usecases;

import app.domain.model.EmergencyContact;
import app.domain.services.emergencycontact.AssignEmergencyContact;

/**
 *
 * @author Dragonico
 */
public class EmergencyContactUseCase {

    private final AssignEmergencyContact assignEmergencyContact;

    public EmergencyContactUseCase(AssignEmergencyContact assignEmergencyContact) {
        this.assignEmergencyContact = assignEmergencyContact;
    }

    public void assign(String patientId, EmergencyContact contact) throws Exception {
        assignEmergencyContact.assign(patientId, contact);
    }
}
