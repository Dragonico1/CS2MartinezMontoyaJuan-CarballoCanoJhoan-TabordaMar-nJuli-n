package app.domain.ports;

import app.domain.model.Employee;

/**
 *
 * @author Dragonico
 */
public interface EmployeePort {
    void registerEmployee(Employee employee)throws Exception;
    void removeEmployee(String employeeId)throws Exception;
    void updateEmployee(String employeeId, Employee updatedData)throws Exception;
    
}
