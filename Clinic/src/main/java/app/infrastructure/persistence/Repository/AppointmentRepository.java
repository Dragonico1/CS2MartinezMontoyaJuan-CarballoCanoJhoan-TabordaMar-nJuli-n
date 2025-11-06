package app.infrastructure.persistence.repository;

import app.infrastructure.persistence.entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, String> {
    AppointmentEntity findByAppointmentId(String appointmentId);
    List<AppointmentEntity> findByPatientId(String patientId);
}
