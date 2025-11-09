package app.adapter.in.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import app.adapter.rest.mapper.EmployeeRestMapper;
import app.adapter.rest.request.EmployeeRequest;
import app.adapter.rest.response.EmployeeResponse;
import app.application.usecases.HumanResourcesUseCase;
import app.domain.model.Employee;

import java.util.List;
import java.util.stream.Collectors;

/**
 * REST controller for employee management.
 * Only accessible by Human Resources role.
 * 
 * Provides endpoints for creating, updating, and retrieving employees.
 * 
 * Methods:
 *  - POST /api/employees → register a new employee
 *  - PUT /api/employees/{id} → update employee info
 *  - GET /api/employees/{id} → get employee by ID
 *  - GET /api/employees → list all employees
 * 
 * @author Dragonico
 */
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private HumanResourcesUseCase hrUseCase;

    @Autowired
    private EmployeeRestMapper mapper;

    // ---------------------- POST ----------------------
    @PostMapping
    public ResponseEntity<?> registerEmployee(
            @RequestBody EmployeeRequest request,
            @RequestHeader("employeeId") String hrId) {

        try {
            Employee employee = mapper.toDomain(request);
            hrUseCase.registerEmployee(hrId, employee); // ✅ corregido
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("✅ Empleado registrado correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("❌ Error al registrar empleado: " + e.getMessage());
        }
    }

    // ---------------------- PUT ----------------------
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(
            @PathVariable String id,
            @RequestBody EmployeeRequest request,
            @RequestHeader("employeeId") String hrId) {

        try {
            Employee updated = mapper.toDomain(request);
            hrUseCase.updateEmployee(hrId, id, updated);
            return ResponseEntity.ok("✅ Empleado actualizado correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("❌ Error al actualizar empleado: " + e.getMessage());
        }
    }

    // ---------------------- GET (uno) ----------------------
    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(
            @PathVariable String id,
            @RequestHeader("employeeId") String hrId) {

        try {
            Employee employee = hrUseCase.searchEmployee(hrId, id);
            EmployeeResponse response = mapper.toResponse(employee);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("❌ Empleado no encontrado: " + e.getMessage());
        }
    }

    // ---------------------- GET (todos) ----------------------
    @GetMapping
    public ResponseEntity<?> getAllEmployees(
            @RequestHeader("employeeId") String hrId) {

        try {
            List<Employee> employees = hrUseCase.listAllEmployees(hrId);
            List<EmployeeResponse> responseList = employees.stream()
                    .map(mapper::toResponse)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(responseList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("❌ Error al listar empleados: " + e.getMessage());
        }
    }
}
