package app.adapter.rest.response;

/**
 * DTO de salida que contiene el token JWT generado.
 * Se devuelve al cliente después del login exitoso.
 * 
 * @author Dragonico
 */
public class TokenResponseDto {
    private String token;

    public TokenResponseDto() {}

    public TokenResponseDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
