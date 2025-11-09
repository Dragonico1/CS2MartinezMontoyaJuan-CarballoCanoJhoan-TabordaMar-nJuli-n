package app.domain.ports;

import app.domain.model.Billing;
import java.util.List;

public interface BillingPort {
    void generateBill(Billing billing) throws Exception;
    void updateBill(long billingId, Billing updatedBilling) throws Exception;
    Billing searchBillingById(long billingId) throws Exception;
    List<Billing> listAllBillings() throws Exception;
}
