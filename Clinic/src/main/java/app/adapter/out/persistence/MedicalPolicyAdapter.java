package app.adapter.out.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.MedicalPolicy;
import app.domain.ports.MedicalPolicyPort;
import app.infrastructure.persistence.entity.MedicalPolicyEntity;
import app.infrastructure.persistence.mapper.MedicalPolicyMapper;
import app.infrastructure.persistence.repository.MedicalPolicyRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Adapter for persistence operations related to MedicalPolicy.
 * Bridges the domain layer with the database using the repository and mapper.
 * 
 * @author Dragonico
 */
@Service
public class MedicalPolicyAdapter implements MedicalPolicyPort {

    @Autowired
    private MedicalPolicyRepository medicalPolicyRepository;

    @Override
    public void registerMedicalPolicy(MedicalPolicy policy) throws Exception {
        if (policy == null)
            throw new Exception("La póliza médica no puede ser nula.");
        medicalPolicyRepository.save(MedicalPolicyMapper.toEntity(policy));
    }

    @Override
    public void updateMedicalPolicy(String policyNumber, MedicalPolicy updatedData) throws Exception {
        MedicalPolicyEntity existing = medicalPolicyRepository.findById(policyNumber)
                .orElseThrow(() -> new Exception("Póliza médica no encontrada con número: " + policyNumber));

        MedicalPolicyEntity updated = MedicalPolicyMapper.toEntity(updatedData);
        updated.setPolicyNumber(existing.getPolicyNumber()); // mantiene el ID
        medicalPolicyRepository.save(updated);
    }

    @Override
    public void removeMedicalPolicy(String policyNumber) throws Exception {
        if (!medicalPolicyRepository.existsById(policyNumber)) {
            throw new Exception("No existe póliza médica con número: " + policyNumber);
        }
        medicalPolicyRepository.deleteById(policyNumber);
    }

    @Override
    public MedicalPolicy searchMedicalPolicyById(String policyNumber) throws Exception {
        MedicalPolicyEntity entity = medicalPolicyRepository.findById(policyNumber)
                .orElseThrow(() -> new Exception("Póliza médica no encontrada con número: " + policyNumber));
        return MedicalPolicyMapper.toDomain(entity);
    }

    @Override
    public boolean isPolicyActive(String policyNumber) throws Exception {
        MedicalPolicyEntity entity = medicalPolicyRepository.findById(policyNumber)
                .orElseThrow(() -> new Exception("Póliza médica no encontrada con número: " + policyNumber));
        return entity.isState();
    }

    @Override
    public List<MedicalPolicy> listAllPolicies() throws Exception {
        return medicalPolicyRepository.findAll()
                .stream()
                .map(MedicalPolicyMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void assignPolicyToPatient(String patientId, MedicalPolicy policy) throws Exception {
        throw new UnsupportedOperationException(
                "La asignación de pólizas a pacientes se realiza desde PatientAdapter.");
    }
}
