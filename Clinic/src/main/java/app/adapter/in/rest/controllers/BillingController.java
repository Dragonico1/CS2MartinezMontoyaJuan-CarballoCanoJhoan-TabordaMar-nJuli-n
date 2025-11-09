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

/**
 * REST controller for managing billing operations.
 * Interacts with the AdministrativeUseCase to generate bills.
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
            // Convertimos el request REST a modelo de dominio
            Billing billing = billingRestMapper.toDomain(request);

            Employee admin = new Employee();
            admin.setId(employeeId);

            administrativeUseCase.generateBill(admin, billing);

            BillingResponse response = billingRestMapper.toResponse(billing);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("❌ Error al generar la factura: " + e.getMessage());
        }
    }

    // ---------------------- (Opcional) GET para probar ----------------------
    @GetMapping("/ping")
    public String testEndpoint() {
        return "✅ BillingController funcionando correctamente.";
    }
}
