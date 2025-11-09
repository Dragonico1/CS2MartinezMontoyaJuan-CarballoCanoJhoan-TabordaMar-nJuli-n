package app.infrastructure.persistence.repository;

import app.infrastructure.persistence.entity.DiagnosticAidOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DiagnosticAidOrderRepository extends JpaRepository<DiagnosticAidOrderEntity, Long> {
    DiagnosticAidOrderEntity findById(long id);
    List<DiagnosticAidOrderEntity> findByPatientId(String patientId);
}
