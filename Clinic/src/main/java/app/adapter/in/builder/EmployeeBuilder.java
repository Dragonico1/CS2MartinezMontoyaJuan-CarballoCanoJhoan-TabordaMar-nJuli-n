package app.adapter.in.builder;

import org.springframework.stereotype.Component;
import app.domain.model.Employee;
import app.domain.model.Emuns.Role;
import app.adapter.in.validators.EmployeeValidator;

/**
 * Builder for creating Employee entities with validation.
 * 
 * @author Dragonico
 */
@Component
public class EmployeeBuilder {

    private final EmployeeValidator validator = new EmployeeValidator();

    public Employee build(String name, String id, String mail, String phone, String address,
                          String username, String password, String role) throws Exception {
        Employee employee = new Employee();

        employee.setName(validator.nameValidator(name));
        employee.setId(validator.idValidator(id));
        employee.setmail(validator.mailValidator(mail));
        employee.setPhoneNum(validator.phoneValidator(phone));
        employee.setAddress(validator.addressValidator(address));
        employee.setUsername(validator.usernameValidator(username));
        employee.setPassword(validator.passwordValidator(password));

        Role validatedRole = Role.valueOf(role); // Convierte texto a enum
        employee.setRole(validator.roleValidator(validatedRole));

        return employee;
    }
}
