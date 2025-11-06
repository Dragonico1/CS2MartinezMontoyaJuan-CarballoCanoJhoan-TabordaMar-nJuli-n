package app.adapter.out.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Billing;
import app.domain.ports.BillingPort;
import app.infrastructure.persistence.entity.BillingEntity;
import app.infrastructure.persistence.mapper.BillingMapper;
import app.infrastructure.persistence.repository.BillingRepository;

@Service
public class BillingAdapter implements BillingPort {

    @Autowired
    private BillingRepository billingRepository;

    @Override
    public void generateBill(Billing bill) throws Exception {
        if (bill == null) {
            throw new Exception("La factura no puede ser nula.");
        }

        BillingEntity entity = BillingMapper.toEntity(bill);
        billingRepository.save(entity);
    }
}
