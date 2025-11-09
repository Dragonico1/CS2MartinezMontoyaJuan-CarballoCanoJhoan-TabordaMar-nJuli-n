package app.application.usecases;

import app.domain.model.Employee;
import app.domain.model.Emuns.Role;
import app.domain.services.employee.*;
import app.domain.ports.EmployeePort;
import app.adapter.in.validators.EmployeeValidator;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Main use case class for the Human Resources (HR) role.
 * Handles employee management operations: register, update, search and list.
 * Only users with the HR role can execute these operations.
 * 
 * @author Dragonico
 */

@Service
public class HumanResourcesUseCase {

    // --------------------- CONSTANT MESSAGES (in Spanish for user feedback) ---------------------
    private static final String ERROR_UNAUTHORIZED_ROLE = "Acción no autorizada: el usuario debe tener el rol de Recursos Humanos.";
    private static final String ERROR_EMPLOYEE_NOT_FOUND = "No se encontró el empleado con el ID: ";
    private static final String ERROR_NULL_EMPLOYEE = "El empleado no puede ser nulo.";
    private static final String ERROR_NULL_UPDATED_DATA = "Los datos actualizados no pueden ser nulos.";
    private static final String ERROR_EMPTY_EMPLOYEE_ID = "El ID del empleado no puede estar vacío.";

    // --------------------- DEPENDENCIES ---------------------
    private final EmployeePort employeePort;
    private final EmployeeValidator validator;

    // --------------------- CONSTRUCTOR ---------------------
    public HumanResourcesUseCase(EmployeePort employeePort) {
        this.employeePort = employeePort;
        this.validator = new EmployeeValidator();
    }

    // --------------------- USE CASE METHODS ---------------------

    /**
     * Registers a new employee.
     * 
     * @param hrId The HR employee performing the action.
     * @param newEmployee The employee to register.
     * @throws Exception if validation fails or role is unauthorized.
     */
    public void registerEmployee(String hrId, Employee newEmployee) throws Exception {
        validateHumanResourcesRole(hrId);
        validateNotNull(newEmployee, ERROR_NULL_EMPLOYEE);

        RegisterEmployee service = new RegisterEmployee(employeePort);
        service.register(newEmployee);
    }

    /**
     * Updates employee information.
     * 
     * @param hrId The HR employee performing the update.
     * @param employeeId The employee ID to update.
     * @param updatedData The new employee data.
     * @throws Exception if validation fails or data is null.
     */
    public void updateEmployee(String hrId, String employeeId, Employee updatedData) throws Exception {
        validateHumanResourcesRole(hrId);
        validateNotNull(updatedData, ERROR_NULL_UPDATED_DATA);

        UpdateEmployee service = new UpdateEmployee(employeePort);
        service.update(employeeId, updatedData);
    }

    /**
     * Searches an employee by ID.
     * 
     * @param hrId The HR employee performing the search.
     * @param employeeId The employee ID to search.
     * @return The found Employee object.
     * @throws Exception if the employee is not found or unauthorized.
     */
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

    /**
     * Lists all employees in the system.
     * 
     * @param hrId The HR employee performing the action.
     * @return A list of all registered employees.
     * @throws Exception if the role is unauthorized.
     */
    public List<Employee> listAllEmployees(String hrId) throws Exception {
        validateHumanResourcesRole(hrId);

        ListAllEmployees service = new ListAllEmployees(employeePort);
        return service.list();
    }

    // --------------------- PRIVATE VALIDATION METHODS ---------------------

    /**
     * Validates that the user performing the operation has the Human Resources role.
     * 
     * @param hrId The ID of the user attempting the action.
     * @throws Exception if the user is not authorized.
     */
    
    private void validateHumanResourcesRole(String hrId) throws Exception {
    SearchEmployeeById finder = new SearchEmployeeById(employeePort);
    Employee employee = finder.search(hrId);

    if (employee == null) {
        throw new Exception(ERROR_EMPLOYEE_NOT_FOUND + hrId);
    }

    // ✅ Permitir acceso también a ADMINISTRATIVE_STAFF
    if (employee.getRole() != Role.HUMAN_RESOURCES) {
        throw new Exception("Acción no autorizada: el usuario debe tener el rol de RRHH o Administrativo.");
    }
}


    /**
     * Validates that an object is not null.
     */
    private void validateNotNull(Object obj, String message) throws Exception {
        if (obj == null) {
            throw new Exception(message);
        }
    }

    /**
     * Validates that a string is not null or blank.
     */
    private void validateString(String value, String message) throws Exception {
        if (value == null || value.isBlank()) {
            throw new Exception(message);
        }
    }
}
