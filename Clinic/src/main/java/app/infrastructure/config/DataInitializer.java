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

            createIfNotExists(repository, encoder,
                    "hr01",
                    "Empleado RRHH",
                    "rrhh@clinic.com",
                    "3000000001",
                    "Oficina RRHH",
                    RoleEntity.HUMAN_RESOURCES,
                    "rrhh123");

            createIfNotExists(repository, encoder,
                    "admin01",
                    "Empleado Administrativo",
                    "admin@clinic.com",
                    "3000000002",
                    "Oficina Administrativa",
                    RoleEntity.ADMIN_STAFF,
                    "admin123");

            createIfNotExists(repository, encoder,
                    "info01",
                    "Soporte Técnico",
                    "soporte@clinic.com",
                    "3000000003",
                    "Centro de Soporte",
                    RoleEntity.INFO_SUPPORT,
                    "info123");

            createIfNotExists(repository, encoder,
                    "nurse01",
                    "Enfermero Principal",
                    "nurse@clinic.com",
                    "3000000004",
                    "Área de Hospitalización",
                    RoleEntity.NURSE,
                    "nurse123");

            createIfNotExists(repository, encoder,
                    "doc01",
                    "Doctor Veterinario",
                    "doctor@clinic.com",
                    "3000000005",
                    "Consultorio 1",
                    RoleEntity.DOCTOR,
                    "doc123");

            System.out.println("✅ Inicialización de empleados completada con todos los roles.");
        };
    }

    private void createIfNotExists(EmployeeRepository repository, PasswordEncoder encoder,
                                   String id, String name, String email, String phone, String address,
                                   RoleEntity role, String rawPassword) {
        if (repository.findByUsername(id) == null) {
            EmployeeEntity e = new EmployeeEntity();
            e.setEmployeeId(id);
            e.setName(name);
            e.setEmail(email);
            e.setPhoneNumber(phone);
            e.setAddress(address);
            e.setRole(role);
            e.setUsername(id);
            e.setPassword(encoder.encode(rawPassword));
            repository.save(e);
            System.out.println("✅ Usuario creado: " + id + " (" + role + ")");
        } else {
            System.out.println("ℹ️ Usuario ya existe: " + id);
        }
    }
}
