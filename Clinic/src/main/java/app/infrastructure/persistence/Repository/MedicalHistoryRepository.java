package app.infrastructure.persistence.repository;

import app.infrastructure.persistence.entity.MedicalHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalHistoryRepository extends JpaRepository<MedicalHistoryEntity, String> {
    MedicalHistoryEntity findByHistoryId(String historyId);
}
