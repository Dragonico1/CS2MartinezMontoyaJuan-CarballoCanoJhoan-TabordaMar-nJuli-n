package app.domain.model;
import app.domain.model.Emuns.Role;
/**
 *
 * @author Dragonico
 */
public class Employee extends Person{
    private Role role;
    private String Username;
    private String Password;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        if (username != null && (username.length() > 15 || !username.matches("[a-zA-Z0-9]+"))) {
            throw new IllegalArgumentException("Username máximo 15 caracteres, solo letras y números");
        }
        this.Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        if (password != null && password.length() < 8) {
            throw new IllegalArgumentException("Contraseña mínimo 8 caracteres");
        }
        this.Password = password;
    } 
    
}
