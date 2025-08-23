package app.domain.services.employee;

import app.domain.model.Employee;
import app.domain.ports.EmployeePort;

/**
 *
 * @author Dragonico
 */
public class UpdateEmployee {

    private EmployeePort employeePort;

    public UpdateEmployee(EmployeePort employeePort) {
        this.employeePort = employeePort;
    }

    public void update(String employeeId, Employee updatedData) throws Exception {
        if (employeeId == null || employeeId.isBlank())
            throw new Exception("El ID del empleado no puede estar vacío");
        if (updatedData == null) throw new Exception("Los datos del empleado no pueden ser nulos");

        employeePort.updateEmployee(employeeId, updatedData);
    }
}
