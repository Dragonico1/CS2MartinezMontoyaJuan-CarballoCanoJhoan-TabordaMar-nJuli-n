package app.domain.ports;

import app.domain.model.Employee;
import java.util.List;

/**
 *
 * @author Dragonico
 */
public interface EmployeePort {
    void registerEmployee(Employee employee) throws Exception;
    void updateEmployee(String employeeId, Employee updatedData) throws Exception;
    void removeEmployee(String employeeId) throws Exception;
    Employee searchEmployeeById(String employeeId) throws Exception;
    List<Employee> listAllEmployees() throws Exception;
}
