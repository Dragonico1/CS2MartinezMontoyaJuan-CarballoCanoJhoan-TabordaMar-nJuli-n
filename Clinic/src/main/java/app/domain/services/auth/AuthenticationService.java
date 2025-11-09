package app.domain.services.auth;

import app.domain.model.Employee;
import app.domain.model.auth.AuthCredentials;
import app.domain.model.auth.TokenResponse;
import app.domain.ports.AuthenticationPort;
import app.domain.ports.EmployeePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Servicio encargado de autenticar empleados mediante JWT.
 * Verifica las credenciales y genera un token de acceso.
 * 
 * @author Dragonico
 */
@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationPort authenticationPort;

    @Autowired
    private EmployeePort employeePort;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Autentica un empleado y genera un token JWT si las credenciales son válidas.
     *
     * @param credentials credenciales ingresadas (usuario y contraseña)
     * @return Token JWT si la autenticación es exitosa
     * @throws Exception si el usuario no existe o la contraseña es incorrecta
     */
    public TokenResponse authenticate(AuthCredentials credentials) throws Exception {
        Employee employee = this.getEmployeeByUsername(credentials.getUsername());
        this.validatePassword(credentials.getPassword(), employee.getPassword());
        return authenticationPort.authenticate(credentials, employee.getRole().name());
    }

    /**
     * Busca un empleado por su nombre de usuario.
     */
    private Employee getEmployeeByUsername(String username) throws Exception {
        Employee employee = employeePort.searchEmployeeById(username); // puedes cambiar si tu método busca por username
        if (employee == null) {
            throw new Exception("Empleado no encontrado con ID: " + username);
        }
        return employee;
    }

    /**
     * Valida la contraseña usando BCrypt.
     */
    private void validatePassword(String inputPassword, String storedPassword) throws Exception {
        if (!passwordEncoder.matches(inputPassword, storedPassword)) {
            throw new Exception("Contraseña incorrecta");
        }
    }
}
