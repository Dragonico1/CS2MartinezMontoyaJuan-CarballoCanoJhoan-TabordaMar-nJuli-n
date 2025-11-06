package app.infrastructure.persistence.entity;

import jakarta.persistence.*;

/**
 * Entity for Employee table in database
 * @author Dragonico
 */
@Entity
@Table(name = "employees")
public class EmployeeEntity {
    
    @Id
    @Column(name = "employee_id", length = 10, nullable = false)
    private String employeeId;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "email", nullable = false)
    private String email;
    
    @Column(name = "phone_number", length = 10, nullable = false)
    private String phoneNumber;
    
    @Column(name = "address", length = 30)
    private String address;
    
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleEntity role;
    
    @Column(name = "username", length = 15, nullable = false, unique = true)
    private String username;
    
    @Column(name = "password", nullable = false)
    private String password;

    public EmployeeEntity() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

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