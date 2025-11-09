package app.application.usecases;

import app.domain.model.auth.AuthCredentials;
import app.domain.model.auth.TokenResponse;
import app.domain.services.auth.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Caso de uso encargado de autenticar usuarios en el sistema.
 * Utiliza AuthenticationService para validar credenciales
 * y generar el token JWT correspondiente.
 * 
 * Endpoint asociado: POST /api/auth/login
 * 
 * @author Dragonico
 */
@Service
public class LoginUseCase {

    private final AuthenticationService authenticationService;

    @Autowired
    public LoginUseCase(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    /**
     * Ejecuta el proceso de autenticación de usuario.
     * 
     * @param credentials Credenciales del usuario (username y password).
     * @return TokenResponse con el JWT generado si la autenticación es exitosa.
     * @throws Exception si las credenciales son inválidas o el usuario no existe.
     */
    public TokenResponse login(AuthCredentials credentials) throws Exception {
        return authenticationService.authenticate(credentials);
    }
}
