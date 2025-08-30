package app.domain.services.employee;

import app.domain.model.Employee;
import app.domain.ports.EmployeePort;

/**
 *
 * @author Dragonico
 */
public class SearchEmployeeById {
    private final EmployeePort employeePort;

    public SearchEmployeeById(EmployeePort employeePort) {
        this.employeePort = employeePort;
    }

    public Employee search(String employeeId) throws Exception {
        if (employeeId == null || employeeId.isEmpty()) throw new Exception("El ID del empleado no puede ser nulo");
        return employeePort.searchEmployeeById(employeeId);
    }
}
