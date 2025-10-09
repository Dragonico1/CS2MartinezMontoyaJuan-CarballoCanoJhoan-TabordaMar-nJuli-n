package app.adapter.in.rest.controllers;

import app.adapter.in.builder.AppointmentBuilder;
import app.adapter.in.rest.request.AppointmentRequest;
import app.application.usecases.AdministrativeUseCase;
import app.domain.model.Appointment;
import app.domain.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing appointments.
 *
 */
@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentBuilder appointmentBuilder;

    @Autowired
    private AdministrativeUseCase administrativeUseCase;

    // Create appointment
    @PostMapping
    public ResponseEntity<?> createAppointment(
            @RequestBody AppointmentRequest request,
            @RequestHeader("employeeId") String employeeId) {
        try {
            Appointment appointment = appointmentBuilder.build(request);

            Employee admin = new Employee();
            admin.setId(employeeId);

            administrativeUseCase.createAppointment(admin, appointment);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Cita registrada correctamente.");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al crear la cita: " + e.getMessage());
        }
    }

    // Update appointment
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
            return ResponseEntity.ok("Cita actualizada correctamente.");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al actualizar la cita: " + e.getMessage());
        }
    }
}
