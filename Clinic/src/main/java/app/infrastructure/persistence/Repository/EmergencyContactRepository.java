package app.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import app.infrastructure.persistence.entity.EmergencyContactEntity;

@Repository
public interface EmergencyContactRepository extends JpaRepository<EmergencyContactEntity, String> {
}
