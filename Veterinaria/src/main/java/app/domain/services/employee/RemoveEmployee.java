package app.domain.services.employee;

import app.domain.ports.EmployeePort;

/**
 *
 * @author Dragonico
 */
public class RemoveEmployee {
    private EmployeePort employeePort;

    public RemoveEmployee(EmployeePort employeePort) {
        this.employeePort = employeePort;
    }

    public void remove(String employeeId) throws Exception {
        if (employeeId == null || employeeId.isBlank())
            throw new Exception("El ID del empleado no puede estar vacío");

        employeePort.removeEmployee(employeeId);
    }
}
