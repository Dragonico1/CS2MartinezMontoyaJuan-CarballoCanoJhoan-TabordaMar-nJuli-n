package app.adapter.rest.request;

/**
 * DTO de entrada para autenticación.
 * Recibe el username y password del cliente.
 * 
 * @author Dragonico
 */
public class AuthRequest {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
