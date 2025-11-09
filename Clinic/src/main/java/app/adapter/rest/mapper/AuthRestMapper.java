package app.adapter.rest.mapper;

import org.springframework.stereotype.Component;

import app.adapter.rest.request.AuthRequest;
import app.adapter.rest.response.TokenResponseDto;
import app.domain.model.auth.AuthCredentials;
import app.domain.model.auth.TokenResponse;

/**
 * Mapper que transforma entre las capas REST y dominio
 * para las operaciones de autenticación (login).
 * 
 * @author Dragonico
 */
@Component
public class AuthRestMapper {

    // Request (REST) → Domain
    public AuthCredentials toDomain(AuthRequest req) {
        AuthCredentials credentials = new AuthCredentials();
        credentials.setUsername(req.getUsername());
        credentials.setPassword(req.getPassword());
        return credentials;
    }

    // Domain → Response (REST)
    public TokenResponseDto toResponse(TokenResponse token) {
        return new TokenResponseDto(token.getToken());
    }
}
