package app.application.usecases;

import app.domain.model.Employee;
import app.domain.services.employee.RegisterEmployee;
import app.domain.services.employee.RemoveEmployee;
import app.domain.services.employee.UpdateEmployee;

/**
 *
 * @author Dragonico
 */
public class EmployeeUseCase {

    private final RegisterEmployee registerEmployee;
    private final RemoveEmployee removeEmployee;
    private final UpdateEmployee updateEmployee;

    public EmployeeUseCase(RegisterEmployee registerEmployee,
                           RemoveEmployee removeEmployee,
                           UpdateEmployee updateEmployee) {
        this.registerEmployee = registerEmployee;
        this.removeEmployee = removeEmployee;
        this.updateEmployee = updateEmployee;
    }

    public void register(Employee employee) throws Exception {
        registerEmployee.register(employee);
    }

    public void remove(String employeeId) throws Exception {
        removeEmployee.remove(employeeId);
    }

    public void update(String employeeId, Employee updatedData) throws Exception {
        updateEmployee.update(employeeId, updatedData);
    }
}
