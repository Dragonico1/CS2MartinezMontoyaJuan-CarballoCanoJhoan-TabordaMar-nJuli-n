package app.adapter.out.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Patient;
import app.domain.model.EmergencyContact;
import app.domain.model.MedicalPolicy;
import app.domain.ports.PatientPort;
import app.infrastructure.persistence.entity.PatientEntity;
import app.infrastructure.persistence.entity.EmergencyContactEntity;
import app.infrastructure.persistence.entity.MedicalPolicyEntity;
import app.infrastructure.persistence.mapper.PatientMapper;
import app.infrastructure.persistence.mapper.EmergencyContactMapper;
import app.infrastructure.persistence.mapper.MedicalPolicyMapper;
import app.infrastructure.persistence.repository.PatientRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientAdapter implements PatientPort {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void registerPatient(Patient patient) throws Exception {
        if (patient == null)
            throw new Exception("El paciente no puede ser nulo");
        patientRepository.save(PatientMapper.toEntity(patient));
    }

    @Override
    public void updatePatient(String patientId, Patient updatedData) throws Exception {
        PatientEntity existing = patientRepository.findById(patientId)
                .orElseThrow(() -> new Exception("Paciente no encontrado con ID: " + patientId));

        PatientEntity updated = PatientMapper.toEntity(updatedData);
        updated.setPatientId(existing.getPatientId());
        patientRepository.save(updated);
    }

    @Override
    public void removePatient(String patientId) throws Exception {
        if (!patientRepository.existsById(patientId)) {
            throw new Exception("No existe paciente con ID: " + patientId);
        }
        patientRepository.deleteById(patientId);
    }

    @Override
    public Patient searchPatientById(String patientId) throws Exception {
        PatientEntity entity = patientRepository.findById(patientId)
                .orElseThrow(() -> new Exception("Paciente no encontrado con ID: " + patientId));
        return PatientMapper.toDomain(entity);
    }

    @Override
    public void assignEmergencyContact(String patientId, EmergencyContact contact) throws Exception {
        PatientEntity patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new Exception("Paciente no encontrado con ID: " + patientId));

        EmergencyContactEntity contactEntity = EmergencyContactMapper.toEntity(contact);
        patient.setEmergencyContact(contactEntity);
        patientRepository.save(patient);
    }

    @Override
    public void assignMedicalPolicy(String patientId, MedicalPolicy policy) throws Exception {
        PatientEntity patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new Exception("Paciente no encontrado con ID: " + patientId));

        MedicalPolicyEntity policyEntity = MedicalPolicyMapper.toEntity(policy);
        patient.setMedicalPolicy(policyEntity);
        patientRepository.save(patient);
    }

    @Override
    public List<Patient> listAllPatients() throws Exception {
        List<PatientEntity> entities = patientRepository.findAll();
        if (entities.isEmpty()) {
            throw new Exception("No hay pacientes registrados en el sistema.");
        }
        return entities.stream()
                .map(PatientMapper::toDomain)
                .collect(Collectors.toList());
    }
}
