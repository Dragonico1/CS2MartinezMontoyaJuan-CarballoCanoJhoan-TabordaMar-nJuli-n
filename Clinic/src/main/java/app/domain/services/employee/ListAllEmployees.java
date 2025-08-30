package app.domain.services.employee;

import app.domain.model.Employee;
import app.domain.ports.EmployeePort;
import java.util.List;

/**
 *
 * @author Dragonico
 */
public class ListAllEmployees {
    private final EmployeePort employeePort;

    public ListAllEmployees(EmployeePort employeePort) {
        this.employeePort = employeePort;
    }

    public List<Employee> list() throws Exception {
        return employeePort.listAllEmployees();
    }
}
