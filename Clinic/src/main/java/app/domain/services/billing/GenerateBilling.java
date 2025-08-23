package app.domain.services.billing;

import app.domain.model.Billing;
import app.domain.ports.BillingPort;

/**
 *
 * @author Dragonico
 */
public class GenerateBilling {
    private BillingPort billingPort;

    public GenerateBilling(BillingPort billingPort) {
        this.billingPort = billingPort;
    }

    public void execute(Billing bill) throws Exception {
        if (bill == null) throw new Exception("La factura no puede ser nula");
        if (bill.getPatient() == null) throw new Exception("Debe asignarse un paciente");
        if (bill.getDoctor() == null) throw new Exception("Debe asignarse un doctor");
        if (bill.getPolicy() == null) throw new Exception("Debe asignarse una póliza");

        billingPort.generateBill(bill);
    }
}