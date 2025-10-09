package app.adapter.in.rest.controllers;

import app.adapter.in.builder.BillingBuilder;
import app.adapter.in.rest.request.BillingRequest;
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
    private BillingBuilder billingBuilder;

    @Autowired
    private AdministrativeUseCase administrativeUseCase;

    /**
     * Endpoint to generate a new billing record.
     */
    @PostMapping
    public ResponseEntity<?> generateBilling(
            @RequestBody BillingRequest request,
            @RequestHeader("employeeId") String employeeId) {
        try {
            Billing billing = billingBuilder.build(request);

            Employee admin = new Employee();
            admin.setId(employeeId);

            administrativeUseCase.generateBill(admin, billing);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Factura generada correctamente.");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al generar la factura: " + e.getMessage());
        }
    }
}
