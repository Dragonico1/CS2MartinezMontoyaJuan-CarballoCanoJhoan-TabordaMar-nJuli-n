package app.adapter.in.rest.controllers;

import app.adapter.rest.mapper.AuthRestMapper;
import app.adapter.rest.request.AuthRequest;
import app.adapter.rest.response.TokenResponseDto;
import app.application.usecases.LoginUseCase;
import app.domain.model.auth.AuthCredentials;
import app.domain.model.auth.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST encargado del login y la generación del JWT.
 * Endpoint: POST /api/auth/login
 * 
 * @author Dragonico
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private LoginUseCase loginUseCase;

    @Autowired
    private AuthRestMapper authRestMapper;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        try {
            AuthCredentials credentials = authRestMapper.toDomain(request);
            TokenResponse token = loginUseCase.login(credentials);
            TokenResponseDto response = authRestMapper.toResponse(token);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("❌ Error de autenticación: " + e.getMessage());
        }
    }
}
