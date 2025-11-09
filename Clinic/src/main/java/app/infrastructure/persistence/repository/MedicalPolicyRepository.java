package app.infrastructure.persistence.repository;

import app.infrastructure.persistence.entity.MedicalPolicyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalPolicyRepository extends JpaRepository<MedicalPolicyEntity, String> {
    MedicalPolicyEntity findByPolicyNumber(String policyNumber);
}
