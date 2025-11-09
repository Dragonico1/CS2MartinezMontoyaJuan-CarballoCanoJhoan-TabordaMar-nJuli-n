package app.infrastructure.config;

import app.infrastructure.persistence.entity.EmployeeEntity;
import app.infrastructure.persistence.entity.RoleEntity;
import app.infrastructure.persistence.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initEmployees(EmployeeRepository repository, PasswordEncoder encoder) {
        return args -> {
            // repository.deleteAll();

            createIfNotExists(repository, encoder,
                    "hr01", "Recursos Humanos",
                    "rh@clinic.com", "3001111111", "Oficina RH",
                    RoleEntity.HUMAN_RESOURCES, "rh", "rh123");

            createIfNotExists(repository, encoder,
                    "admin01", "Administrador General",
                    "admin@clinic.com", "3000000000", "Oficina Central",
                    RoleEntity.ADMIN_STAFF, "admin", "admin123");

            createIfNotExists(repository, encoder,
                    "it01", "Soporte Técnico",
                    "it@clinic.com", "3002222222", "Sala de Servidores",
                    RoleEntity.INFO_SUPPORT, "it", "it123");

            createIfNotExists(repository, encoder,
                    "nurse01", "Enfermera Jefe",
                    "nurse@clinic.com", "3003333333", "Pabellón A",
                    RoleEntity.NURSE, "nurse", "nurse123");

            createIfNotExists(repository, encoder,
                    "doctor01", "Doctor Principal",
                    "doctor@clinic.com", "3004444444", "Consultorio 1",
                    RoleEntity.DOCTOR, "doctor", "doctor123");
        };
    }

    private void createIfNotExists(EmployeeRepository repository, PasswordEncoder encoder,
                                   String employeeId, String name, String email,
                                   String phone, String address, RoleEntity role,
                                   String username, String rawPassword) {
        try {
            if (repository.findByUsername(username) == null) {
                EmployeeEntity employee = new EmployeeEntity();
                employee.setEmployeeId(employeeId);
                employee.setName(name);
                employee.setEmail(email);
                employee.setPhoneNumber(phone);
                employee.setAddress(address);
                employee.setRole(role);
                employee.setUsername(username);
                employee.setPassword(encoder.encode(rawPassword));

                repository.save(employee);
                System.out.println("✅ Usuario creado: " + username + " (" + role + ")");
            } else {
                System.out.println("ℹ️ Usuario ya existe: " + username);
            }
        } catch (Exception e) {
            System.err.println("❌ Error al crear usuario " + username + ": " + e.getMessage());
        }
    }
}
