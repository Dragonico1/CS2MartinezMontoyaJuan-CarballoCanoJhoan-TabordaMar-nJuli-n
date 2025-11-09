package app.domain.services.employee;

import app.domain.model.Employee;
import app.domain.ports.EmployeePort;

/**
 *
 * @author Dragonico
 */
public class RegisterEmployee {

    private final EmployeePort employeePort;

    public RegisterEmployee(EmployeePort employeePort) {
        this.employeePort = employeePort;
    }

    public void register(Employee employee) throws Exception {
        if (employee == null) 
            throw new Exception("El empleado no puede ser nulo");
    
        if (employee.getID() == null || employee.getID().isBlank()) 
            throw new Exception("El empleado debe tener un ID válido");

        if (employee.getUsername() == null || employee.getUsername().isBlank())
            throw new Exception("El empleado debe tener un username válido");

        employeePort.registerEmployee(employee);
    }
}
