package app.domain.ports;

import app.domain.model.Patient;
import app.domain.model.EmergencyContact;
import app.domain.model.MedicalPolicy;

/**
 *
 * @author Dragonico
 */
public interface PatientPort {
    void registerPatient(Patient patient)throws Exception;
    void updatePatient(String patientId, Patient updatedData)throws Exception;
    void assignEmergencyContact(String patientId, EmergencyContact contact)throws Exception;
    void assignMedicalPolicy(String patientId, MedicalPolicy policy)throws Exception;
    
}
