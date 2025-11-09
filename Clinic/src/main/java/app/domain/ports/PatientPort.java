package app.domain.ports;

import app.domain.model.Patient;
import app.domain.model.EmergencyContact;
import app.domain.model.MedicalPolicy;
import java.util.List;

/**
 * Port interface for patient persistence operations.
 * Defines all required interactions between domain and infrastructure layers.
 * 
 * @author Dragonico
 */
public interface PatientPort {

    void registerPatient(Patient patient) throws Exception;
    void updatePatient(String patientId, Patient updatedData) throws Exception;
    void removePatient(String patientId) throws Exception;
    Patient searchPatientById(String patientId) throws Exception;
    void assignEmergencyContact(String patientId, EmergencyContact contact) throws Exception;
    void assignMedicalPolicy(String patientId, MedicalPolicy policy) throws Exception;
    List<Patient> listAllPatients() throws Exception;
}
