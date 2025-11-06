package app.adapter.out.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Employee;
import app.domain.ports.EmployeePort;
import app.infrastructure.persistence.entity.EmployeeEntity;
import app.infrastructure.persistence.mapper.EmployeeMapper;
import app.infrastructure.persistence.repository.EmployeeRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Adapter that connects the domain EmployeePort interface 
 * with the persistence layer using JPA.
 * 
 * @author Dragonico
 */
@Service
public class EmployeeAdapter implements EmployeePort {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void registerEmployee(Employee employee) throws Exception {
        if (employee == null) {
            throw new Exception("El empleado no puede ser nulo");
        }
        employeeRepository.save(EmployeeMapper.toEntity(employee));
    }

    @Override
    public void updateEmployee(String employeeId, Employee updatedData) throws Exception {
        EmployeeEntity existing = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new Exception("Empleado no encontrado con ID: " + employeeId));

        EmployeeEntity updated = EmployeeMapper.toEntity(updatedData);
        updated.setEmployeeId(existing.getEmployeeId());
        employeeRepository.save(updated);
    }

    @Override
    public void removeEmployee(String employeeId) throws Exception {
        if (!employeeRepository.existsById(employeeId)) {
            throw new Exception("Empleado no encontrado con ID: " + employeeId);
        }
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public Employee searchEmployeeById(String employeeId) throws Exception {
        EmployeeEntity entity = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new Exception("Empleado no encontrado con ID: " + employeeId));
        return EmployeeMapper.toDomain(entity);
    }

    @Override
    public List<Employee> listAllEmployees() throws Exception {
        return employeeRepository.findAll()
                .stream()
                .map(EmployeeMapper::toDomain)
                .collect(Collectors.toList());
    }
}
