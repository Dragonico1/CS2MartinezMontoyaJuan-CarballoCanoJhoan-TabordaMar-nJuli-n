package app.infrastructure.persistence.repository;

import app.infrastructure.persistence.entity.ProcedureOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProcedureOrderRepository extends JpaRepository<ProcedureOrderEntity, Long> {
    ProcedureOrderEntity findById(long id);
    List<ProcedureOrderEntity> findByPatientId(String patientId);
}
