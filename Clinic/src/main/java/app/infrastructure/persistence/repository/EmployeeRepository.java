package app.infrastructure.persistence.repository;

import app.infrastructure.persistence.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, String> {

    EmployeeEntity findByEmployeeId(String employeeId);
    EmployeeEntity findByUsername(String username);
}
