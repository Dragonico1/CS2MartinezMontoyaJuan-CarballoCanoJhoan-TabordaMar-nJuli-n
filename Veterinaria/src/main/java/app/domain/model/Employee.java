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

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    } 
    
}
