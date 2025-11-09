package app.adapter.in.rest.controllers;

import app.adapter.rest.mapper.BillingRestMapper;
import app.adapter.rest.request.BillingRequest;
import app.adapter.rest.response.BillingResponse;
import app.application.usecases.AdministrativeUseCase;
import app.domain.model.Billing;
import app.domain.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * REST controller for managing billing operations.
 * Handles creation, update, deletion, and retrieval of billing records.
 * 
 * @author Dragonico
 */
@RestController
@RequestMapping("/api/billing")
public class BillingController {

    @Autowired
    private AdministrativeUseCase administrativeUseCase;

    @Autowired
    private BillingRestMapper billingRestMapper;

    // ---------------------- POST (Crear factura) ----------------------
    @PostMapping
    public ResponseEntity<?> generateBilling(
            @RequestBody BillingRequest request,
            @RequestHeader("employeeId") String employeeId) {
        try {
            Billing billing = billingRestMapper.toDomain(request);
            Employee admin = new Employee();
            admin.setId(employeeId);

            administrativeUseCase.generateBill(admin, billing);
            BillingResponse response = billingRestMapper.toResponse(billing);

            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("❌ Error al generar la factura: " + e.getMessage());
        }
    }

    // ---------------------- PUT (Actualizar factura) ----------------------
    @PutMapping("/{id}")
    public ResponseEntity<?> updateBilling(
            @PathVariable String id,
            @RequestBody BillingRequest request,
            @RequestHeader("employeeId") String employeeId) {
        try {
            Billing billing = billingRestMapper.toDomain(request);
            billing.setID(id);

            Employee admin = new Employee();
            admin.setId(employeeId);

            administrativeUseCase.updateBilling(admin, billing);

            return ResponseEntity.ok("✅ Factura actualizada correctamente.");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("❌ Error al actualizar factura: " + e.getMessage());
        }
    }

    // ---------------------- GET (Obtener factura por ID) ----------------------
    @GetMapping("/{id}")
    public ResponseEntity<?> getBillingById(
            @PathVariable String id,
            @RequestHeader("employeeId") String employeeId) {
        try {
            Employee admin = new Employee();
            admin.setId(employeeId);

            Billing billing = administrativeUseCase.searchBillingById(admin, id);
            BillingResponse response = billingRestMapper.toResponse(billing);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("❌ Factura no encontrada: " + e.getMessage());
        }
    }

    // ---------------------- GET (Listar todas las facturas) ----------------------
    @GetMapping
    public ResponseEntity<?> listAllBillings(@RequestHeader("employeeId") String employeeId) {
        try {
            Employee admin = new Employee();
            admin.setId(employeeId);

            List<Billing> billings = administrativeUseCase.listAllBillings(admin);
            List<BillingResponse> responses = billings.stream()
                    .map(billingRestMapper::toResponse)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(responses);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("❌ Error al listar facturas: " + e.getMessage());
        }
    }

    // ---------------------- GET (Probar conexión rápida) ----------------------
    @GetMapping("/ping")
    public String testEndpoint() {
        return "✅ BillingController funcionando correctamente.";
    }
}
