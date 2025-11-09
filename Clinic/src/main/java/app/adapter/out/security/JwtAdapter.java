package app.adapter.out.security;

import app.domain.model.auth.AuthCredentials;
import app.domain.model.auth.TokenResponse;
import app.domain.ports.AuthenticationPort;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;
import java.util.UUID;

/**
 * Implementación del AuthenticationPort que genera, valida y lee JWT.
 * Usa HS256 con una clave secreta generada automáticamente.
 * 
 * @author Dragonico
 */
@Component
public class JwtAdapter implements AuthenticationPort {

    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final long EXPIRATION_TIME = 15 * 60 * 1000; // 15 minutos

    @Override
    public TokenResponse authenticate(AuthCredentials credentials, String role) {
        String token = generateToken(credentials.getUsername(), role);
        TokenResponse response = new TokenResponse();
        response.setToken(token);
        return response;
    }

    @Override
    public boolean validateToken(String token) {
        try {
            getClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    @Override
    public String extractRole(String token) {
        return getClaims(token).get("role", String.class);
    }

    private String generateToken(String username, String role) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + EXPIRATION_TIME);

        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SECRET_KEY)
                .compact();
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
