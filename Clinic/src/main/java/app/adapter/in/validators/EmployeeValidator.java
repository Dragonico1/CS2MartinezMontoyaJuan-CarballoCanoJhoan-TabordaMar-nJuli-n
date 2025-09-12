package app.adapter.in.validators;

import app.domain.model.Emuns.Role;

/**
 *
 * @author Dragonico
 */
public class EmployeeValidator extends PersonValidator {
    
    public String usernameValidator(String username) throws Exception {
        stringValidator("username", username);
        if (username.length() > 15 || !username.matches("[a-zA-Z0-9]+")) {
            throw new Exception("El username debe tener máximo 15 caracteres y solo letras o números");
        }
        return username;
    }
    
    public String passwordValidator(String password) throws Exception {
        stringValidator("contraseña", password);
        if (password.length() < 8) {
            throw new Exception("La contraseña debe tener al menos 8 caracteres");
        }
        return password;
    }
    
    public Role roleValidator(Role role) throws Exception {
        if (role == null) {
            throw new Exception("El rol del empleado no puede ser nulo");
        }
        return role;
    }
}
