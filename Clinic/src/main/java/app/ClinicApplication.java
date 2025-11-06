package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Spring Boot entry point for the Clinic system.
 * Scans all components under the "app" base package.
 * 
 * @author Dragonico
 */
@SpringBootApplication(scanBasePackages = "app")
public class ClinicApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClinicApplication.class, args);
        System.out.println("✅ Clinic Application started successfully!");
    }
}
