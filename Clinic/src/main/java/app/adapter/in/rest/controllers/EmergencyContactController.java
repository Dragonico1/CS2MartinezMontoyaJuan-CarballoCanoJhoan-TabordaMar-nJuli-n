package app.adapter.in.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import app.adapter.in.builder.EmergencyContactBuilder;
import app.adapter.rest.mapper.EmergencyContactRestMapper;
import app.adapter.rest.request.EmergencyContactRequest;
import app.adapter.rest.response.EmergencyContactResponse;
import app.application.usecases.AdministrativeUseCase;
import app.domain.model.Employee;
import app.domain.model.EmergencyContact;

import java.util.List;
import java.util.stream.Collectors;

/**
 * REST controller for emergency contact management.
 * Accessible only by administrative staff.
 *
 * Endpoints:
 *  - POST /api/emergency-contacts → create a new emergency contact
 *  - PUT /api/emergency-contacts/{id} → update a contact
 *  - GET /api/emergency-contacts/{id} → get a contact by ID
 *  - GET /api/emergency-contacts → list all contacts
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

    @Autowired
    private EmergencyContactRestMapper mapper;

    // ---------------------- POST ----------------------
    @PostMapping
    public ResponseEntity<?> createEmergencyContact(
            @RequestBody EmergencyContactRequest request,
            @RequestHeader("employeeId") String employeeId) {
        try {
            Employee admin = new Employee();
            admin.setId(employeeId);

            EmergencyContact contact = mapper.toDomain(request);

            administrativeUseCase.registerEmergencyContact(admin, contact);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("✅ Contacto de emergencia registrado correctamente.");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("❌ Error al registrar el contacto de emergencia: " + e.getMessage());
        }
    }

    // ---------------------- PUT ----------------------
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmergencyContact(
            @PathVariable Long id,
            @RequestBody EmergencyContactRequest request,
            @RequestHeader("employeeId") String employeeId) {
        try {
            Employee admin = new Employee();
            admin.setId(employeeId);

            // Mapea y asigna el ID
            EmergencyContact updatedContact = mapper.toDomain(request);
            updatedContact.setId(id);

            // Llamada futura (aún no existe)
            administrativeUseCase.updateEmergencyContact(admin, updatedContact);

            return ResponseEntity.ok("✅ Contacto de emergencia actualizado correctamente.");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("❌ Error al actualizar contacto: " + e.getMessage());
        }
    }

    // ---------------------- GET (uno) ----------------------
    @GetMapping("/{id}")
    public ResponseEntity<?> getEmergencyContactById(
            @PathVariable Long id,
            @RequestHeader("employeeId") String employeeId) {
        try {
            Employee admin = new Employee();
            admin.setId(employeeId);

            // Llamada futura (aún no existe)
            EmergencyContact contact = administrativeUseCase.searchEmergencyContactById(admin, id);
            EmergencyContactResponse response = mapper.toResponse(contact);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("❌ Contacto no encontrado: " + e.getMessage());
        }
    }

    // ---------------------- GET (todos) ----------------------
    @GetMapping
    public ResponseEntity<?> getAllEmergencyContacts(
            @RequestHeader("employeeId") String employeeId) {
        try {
            Employee admin = new Employee();
            admin.setId(employeeId);

            // Llamada futura (aún no existe)
            List<EmergencyContact> contacts = administrativeUseCase.listAllEmergencyContacts(admin);
            List<EmergencyContactResponse> responseList = contacts.stream()
                    .map(mapper::toResponse)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(responseList);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("❌ Error al listar contactos: " + e.getMessage());
        }
    }
}
