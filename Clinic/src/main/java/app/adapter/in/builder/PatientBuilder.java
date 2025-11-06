package app.adapter.in.builder;

import org.springframework.stereotype.Component;

import app.domain.model.EmergencyContact;
import app.domain.model.MedicalPolicy;
import app.domain.model.Patient;
import app.adapter.in.rest.request.PatientRequest;

/**
 * Builds a Patient domain object from a PatientRequest.
 * Encapsulates validation and object composition logic.
 * 
 * @author Dragonico
 */
@Component
public class PatientBuilder {

    public Patient build(PatientRequest request) throws Exception {
        if (request == null) {
            throw new Exception("La solicitud de paciente no puede ser nula");
        }

        Patient patient = new Patient();
        patient.setName(request.getName());
        patient.setId(request.getId());
        patient.setmail(request.getMail());
        patient.setPhoneNum(request.getPhoneNum());
        patient.setAddress(request.getAddress());
        patient.setBirthDate(request.getBirthdate());
        patient.setGender(request.getGender());

        // Construir contacto de emergencia
        EmergencyContact emergencyContact = new EmergencyContact();
        emergencyContact.setName(request.getEmergencyContactName());
        emergencyContact.setRelation(request.getEmergencyContactRelation());
        emergencyContact.setPhoneNumber(request.getEmergencyContactPhone());
        patient.setEmergencyCon(emergencyContact);

        // Construir póliza médica
        MedicalPolicy policy = new MedicalPolicy();
        policy.setInsureName(request.getInsureName());
        policy.setPolicyNumber(request.getPolicyNumber());
        policy.setState(request.isPolicyState());
        policy.setPolicyDuration(request.getPolicyDuration());
        patient.setPolicy(policy);

        return patient;
    }
}
