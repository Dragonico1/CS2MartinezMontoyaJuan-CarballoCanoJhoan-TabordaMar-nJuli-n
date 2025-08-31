package app.application.usecases;

import app.domain.model.Patient;
import app.domain.model.EmergencyContact;
import app.domain.model.MedicalPolicy;
import app.domain.services.patient.RegisterPatient;
import app.domain.services.patient.UpdatePatient;
import app.domain.services.patient.AssignEmergencyContact;
import app.domain.services.patient.AssignMedicalPolicy;

/**
 *
 * @author Dragonico
 */
public class PatientUseCase {

    private final RegisterPatient registerPatient;
    private final UpdatePatient updatePatient;
    private final AssignEmergencyContact assignEmergencyContact;
    private final AssignMedicalPolicy assignMedicalPolicy;

    public PatientUseCase(RegisterPatient registerPatient,
                          UpdatePatient updatePatient,
                          AssignEmergencyContact assignEmergencyContact,
                          AssignMedicalPolicy assignMedicalPolicy) {
        this.registerPatient = registerPatient;
        this.updatePatient = updatePatient;
        this.assignEmergencyContact = assignEmergencyContact;
        this.assignMedicalPolicy = assignMedicalPolicy;
    }

    public void register(Patient patient) throws Exception {
        registerPatient.register(patient);
    }

    public void update(String patientId, Patient updatedData) throws Exception {
        updatePatient.update(patientId, updatedData);
    }

    public void assignEmergencyContact(String patientId, EmergencyContact contact) throws Exception {
        assignEmergencyContact.assign(patientId, contact);
    }

    public void assignMedicalPolicy(String patientId, MedicalPolicy policy) throws Exception {
        assignMedicalPolicy.assign(patientId, policy);
    }
}
