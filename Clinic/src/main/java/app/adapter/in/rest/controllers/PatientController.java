package app.adapter.in.rest.controllers;

import app.adapter.in.builder.PatientBuilder;
import app.adapter.in.rest.request.PatientRequest;
import app.adapter.rest.mapper.PatientRestMapper;
import app.adapter.rest.response.PatientResponse;
import app.application.usecases.AdministrativeUseCase;
import app.domain.model.Employee;
import app.domain.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * REST controller for managing patients.
 * Handles registration, updates, and retrieval via AdministrativeUseCase.
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

    @Autowired
    private PatientRestMapper patientRestMapper;

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

    // -------------------- GET PATIENT BY ID --------------------
    @GetMapping("/{id}")
    public ResponseEntity<?> getPatientById(
            @PathVariable String id,
            @RequestHeader("employeeId") String employeeId) {
        try {
            Employee admin = new Employee();
            admin.setId(employeeId);

            Patient patient = administrativeUseCase.searchPatient(admin, id);
            PatientResponse response = patientRestMapper.toResponse(patient);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error al obtener paciente: " + e.getMessage());
        }
    }

    // -------------------- LIST ALL PATIENTS --------------------
    @GetMapping
    public ResponseEntity<?> listAllPatients(@RequestHeader("employeeId") String employeeId) {
        try {
            Employee admin = new Employee();
            admin.setId(employeeId);

            List<Patient> patients = administrativeUseCase.listAllPatients(admin);
            List<PatientResponse> responses = patients.stream()
                    .map(patientRestMapper::toResponse)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(responses);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al listar pacientes: " + e.getMessage());
        }
    }
}
