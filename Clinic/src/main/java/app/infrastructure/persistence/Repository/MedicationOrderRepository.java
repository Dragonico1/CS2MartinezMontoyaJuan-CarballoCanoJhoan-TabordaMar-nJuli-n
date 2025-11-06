package app.infrastructure.persistence.repository;

import app.infrastructure.persistence.entity.MedicationOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MedicationOrderRepository extends JpaRepository<MedicationOrderEntity, Long> {
    MedicationOrderEntity findById(long id);
    List<MedicationOrderEntity> findByPatientId(String patientId);
}
