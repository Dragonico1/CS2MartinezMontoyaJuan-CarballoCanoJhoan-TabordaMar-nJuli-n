package app.application.usecases;

import app.domain.model.Employee;
import app.domain.model.Emuns.Role;
import app.domain.services.employee.*;
import app.domain.ports.EmployeePort;
import app.adapter.in.validators.EmployeeValidator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class HumanResourcesUseCase {

    private static final String ERROR_UNAUTHORIZED_ROLE = "Acción no autorizada: el usuario debe tener el rol de Recursos Humanos.";
    private static final String ERROR_EMPLOYEE_NOT_FOUND = "No se encontró el empleado con el ID: ";
    private static final String ERROR_NULL_EMPLOYEE = "El empleado no puede ser nulo.";
    private static final String ERROR_NULL_UPDATED_DATA = "Los datos actualizados no pueden ser nulos.";
    private static final String ERROR_EMPTY_EMPLOYEE_ID = "El ID del empleado no puede estar vacío.";

    private final EmployeePort employeePort;
    private final EmployeeValidator validator;
    private final PasswordEncoder passwordEncoder;

    public HumanResourcesUseCase(EmployeePort employeePort) {
        this.employeePort = employeePort;
        this.validator = new EmployeeValidator();
        this.passwordEncoder = new BCryptPasswordEncoder(); // ✅ Inicialización
    }

    public void registerEmployee(String hrId, Employee newEmployee) throws Exception {
        validateHumanResourcesRole(hrId);
        validateNotNull(newEmployee, ERROR_NULL_EMPLOYEE);

        // ✅ Cifrar contraseña antes de guardar
        if (newEmployee.getPassword() != null && !newEmployee.getPassword().isBlank()) {
            newEmployee.setPassword(passwordEncoder.encode(newEmployee.getPassword()));
        }

        RegisterEmployee service = new RegisterEmployee(employeePort);
        service.register(newEmployee);
    }

    public void updateEmployee(String hrId, String employeeId, Employee updatedData) throws Exception {
        validateHumanResourcesRole(hrId);
        validateNotNull(updatedData, ERROR_NULL_UPDATED_DATA);

        // ✅ Cifrar contraseña si se envía en la actualización
        if (updatedData.getPassword() != null && !updatedData.getPassword().isBlank()) {
            updatedData.setPassword(passwordEncoder.encode(updatedData.getPassword()));
        }

        UpdateEmployee service = new UpdateEmployee(employeePort);
        service.update(employeeId, updatedData);
    }

    public Employee searchEmployee(String hrId, String employeeId) throws Exception {
        validateHumanResourcesRole(hrId);
        validateString(employeeId, ERROR_EMPTY_EMPLOYEE_ID);

        SearchEmployeeById service = new SearchEmployeeById(employeePort);
        Employee found = service.search(employeeId);

        if (found == null) {
            throw new Exception(ERROR_EMPLOYEE_NOT_FOUND + employeeId);
        }

        return found;
    }

    public List<Employee> listAllEmployees(String hrId) throws Exception {
        validateHumanResourcesRole(hrId);

        ListAllEmployees service = new ListAllEmployees(employeePort);
        return service.list();
    }

    private void validateHumanResourcesRole(String hrId) throws Exception {
        SearchEmployeeById finder = new SearchEmployeeById(employeePort);
        Employee employee = finder.search(hrId);

        if (employee == null) {
            throw new Exception(ERROR_EMPLOYEE_NOT_FOUND + hrId);
        }

        if (employee.getRole() != Role.HUMAN_RESOURCES) {
            throw new Exception("Acción no autorizada: el usuario debe tener el rol de RRHH o Administrativo.");
        }
    }

    private void validateNotNull(Object obj, String message) throws Exception {
        if (obj == null) {
            throw new Exception(message);
        }
    }

    private void validateString(String value, String message) throws Exception {
        if (value == null || value.isBlank()) {
            throw new Exception(message);
        }
    }
}