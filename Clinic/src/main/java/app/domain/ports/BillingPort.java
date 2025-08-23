package app.domain.ports;

import app.domain.model.Billing;

/**
 *
 * @author Dragonico
 */
public interface BillingPort {
    void generateBill(Billing bill) throws Exception;
}
