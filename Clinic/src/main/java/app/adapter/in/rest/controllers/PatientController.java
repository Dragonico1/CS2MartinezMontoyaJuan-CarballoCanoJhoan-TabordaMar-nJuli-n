package app.adapter.in.rest.controllers;

import app.adapter.in.builder.PatientBuilder;
import app.adapter.in.rest.request.PatientRequest;
import app.application.usecases.AdministrativeUseCase;
import app.domain.model.Employee;
import app.domain.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing patients.
 * Handles registration and updates via AdministrativeUseCase.
 * 
 * @author Dragonico
 */
@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientBuilder patientBuilder;

    @Autowired
    private AdministrativeUseCase administrativeUseCase;

    // -------------------- REGISTER PATIENT --------------------
    @PostMapping
    public ResponseEntity<?> registerPatient(
            @RequestBody PatientRequest request,
            @RequestHeader("employeeId") String employeeId) {
        try {
            Patient patient = patientBuilder.build(request);

            Employee admin = new Employee();
            admin.setId(employeeId);

            administrativeUseCase.registerPatient(admin, patient);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Paciente registrado correctamente");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al registrar paciente: " + e.getMessage());
        }
    }

    // -------------------- UPDATE PATIENT --------------------
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePatient(
            @PathVariable String id,
            @RequestBody PatientRequest request,
            @RequestHeader("employeeId") String employeeId) {
        try {
            Patient patient = patientBuilder.build(request);

            Employee admin = new Employee();
            admin.setId(employeeId);

            administrativeUseCase.updatePatient(admin, id, patient);
            return ResponseEntity.ok("Paciente actualizado correctamente");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al actualizar paciente: " + e.getMessage());
        }
    }
}
