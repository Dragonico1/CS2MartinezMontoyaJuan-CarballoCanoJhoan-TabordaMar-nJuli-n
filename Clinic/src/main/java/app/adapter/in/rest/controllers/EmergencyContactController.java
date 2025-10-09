package app.adapter.in.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import app.adapter.in.builder.EmergencyContactBuilder;
import app.adapter.in.rest.request.EmergencyContactRequest;
import app.application.usecases.AdministrativeUseCase;
import app.domain.model.Employee;
import app.domain.model.EmergencyContact;

/**
 * REST controller for emergency contact management.
 * Accessible only by administrative staff.
 * 
 * @author Dragonico
 */
@RestController
@RequestMapping("/api/emergency-contacts")
public class EmergencyContactController {

    @Autowired
    private EmergencyContactBuilder contactBuilder;

    @Autowired
    private AdministrativeUseCase administrativeUseCase;

    @PostMapping
    public ResponseEntity<?> createEmergencyContact(
            @RequestBody EmergencyContactRequest request,
            @RequestHeader("employeeId") String employeeId) {
        try {
            Employee admin = new Employee();
            admin.setId(employeeId); // ✅ método correcto

            EmergencyContact contact = contactBuilder.build(
                    request.getName(),
                    request.getRelation(),
                    request.getPhone()
            );

            administrativeUseCase.registerEmergencyContact(admin, contact);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Contacto de emergencia registrado correctamente.");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al registrar el contacto de emergencia: " + e.getMessage());
        }
    }
}
