package app.adapter.in.rest.controllers;

import app.adapter.in.builder.AppointmentBuilder;
import app.adapter.rest.mapper.AppointmentRestMapper;
import app.adapter.rest.request.AppointmentRequest;
import app.adapter.rest.response.AppointmentResponse;
import app.application.usecases.AdministrativeUseCase;
import app.domain.model.Appointment;
import app.domain.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * REST controller for managing appointments.
 * Handles creation, update, and retrieval of appointments.
 * 
 * @author Dragonico
 */
@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentBuilder appointmentBuilder;

    @Autowired
    private AppointmentRestMapper appointmentRestMapper;

    @Autowired
    private AdministrativeUseCase administrativeUseCase;

    // -------------------- CREATE APPOINTMENT --------------------
    @PostMapping
    public ResponseEntity<?> createAppointment(
            @RequestBody AppointmentRequest request,
            @RequestHeader("employeeId") String employeeId) {
        try {
            Appointment appointment = appointmentBuilder.build(request);

            Employee admin = new Employee();
            admin.setId(employeeId);

            administrativeUseCase.createAppointment(admin, appointment);
            AppointmentResponse response = appointmentRestMapper.toResponse(appointment);

            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("❌ Error al crear la cita: " + e.getMessage());
        }
    }

    // -------------------- UPDATE APPOINTMENT --------------------
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAppointment(
            @PathVariable String id,
            @RequestBody AppointmentRequest request,
            @RequestHeader("employeeId") String employeeId) {
        try {
            Appointment appointment = appointmentBuilder.build(request);

            Employee admin = new Employee();
            admin.setId(employeeId);

            administrativeUseCase.updateAppointment(admin, id, appointment);
            AppointmentResponse response = appointmentRestMapper.toResponse(appointment);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("❌ Error al actualizar la cita: " + e.getMessage());
        }
    }

    // -------------------- GET APPOINTMENT BY ID --------------------
    @GetMapping("/{id}")
    public ResponseEntity<?> getAppointmentById(
            @PathVariable String id,
            @RequestHeader("employeeId") String employeeId) {
        try {
            Employee admin = new Employee();
            admin.setId(employeeId);

            Appointment appointment = administrativeUseCase.searchAppointmentById(admin, id);
            AppointmentResponse response = appointmentRestMapper.toResponse(appointment);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("❌ Cita no encontrada: " + e.getMessage());
        }
    }

    // -------------------- LIST ALL APPOINTMENTS --------------------
    @GetMapping
    public ResponseEntity<?> listAllAppointments(
            @RequestHeader("employeeId") String employeeId) {
        try {
            Employee admin = new Employee();
            admin.setId(employeeId);

            List<Appointment> appointments = administrativeUseCase.listAllAppointments(admin);
            List<AppointmentResponse> responses = appointments.stream()
                    .map(appointmentRestMapper::toResponse)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(responses);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("❌ Error al listar citas: " + e.getMessage());
        }
    }
}
