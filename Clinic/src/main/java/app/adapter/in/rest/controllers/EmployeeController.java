package app.adapter.in.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import app.adapter.in.builder.EmployeeBuilder;
import app.adapter.in.rest.request.EmployeeRequest;
import app.application.usecases.HumanResourcesUseCase;
import app.domain.model.Employee;
import java.util.List;

/**
 * REST controller for employee management.
 * Only accessible by Human Resources role.
 * 
 * @author Dragonico
 */
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeBuilder employeeBuilder;

    @Autowired
    private HumanResourcesUseCase hrUseCase;

    @PostMapping
    public ResponseEntity<?> registerEmployee(
            @RequestBody EmployeeRequest request,
            @RequestHeader("employeeId") String hrId) {
        try {
            Employee newEmployee = employeeBuilder.build(
                    request.getName(),
                    request.getId(),
                    request.getMail(),
                    request.getPhone(),
                    request.getAddress(),
                    request.getUsername(),
                    request.getPassword(),
                    request.getRole()
            );

            hrUseCase.registerEmployee(hrId, newEmployee);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Empleado registrado correctamente.");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al registrar empleado: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(
            @PathVariable String id,
            @RequestBody EmployeeRequest request,
            @RequestHeader("employeeId") String hrId) {
        try {
            Employee updatedEmployee = employeeBuilder.build(
                    request.getName(),
                    request.getId(),
                    request.getMail(),
                    request.getPhone(),
                    request.getAddress(),
                    request.getUsername(),
                    request.getPassword(),
                    request.getRole()
            );

            hrUseCase.updateEmployee(hrId, id, updatedEmployee);
            return ResponseEntity.ok("Empleado actualizado correctamente.");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al actualizar empleado: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> searchEmployee(
            @PathVariable String id,
            @RequestHeader("employeeId") String hrId) {
        try {
            Employee employee = hrUseCase.searchEmployee(hrId, id);
            return ResponseEntity.ok(employee);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al buscar empleado: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> listAllEmployees(
            @RequestHeader("employeeId") String hrId) {
        try {
            List<Employee> employees = hrUseCase.listAllEmployees(hrId);
            return ResponseEntity.ok(employees);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al listar empleados: " + e.getMessage());
        }
    }
}
