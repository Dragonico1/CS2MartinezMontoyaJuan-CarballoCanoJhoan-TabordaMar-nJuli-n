package app.adapter.out.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.domain.model.Billing;
import app.domain.ports.BillingPort;
import app.infrastructure.persistence.entity.BillingEntity;
import app.infrastructure.persistence.mapper.BillingMapper;
import app.infrastructure.persistence.repository.BillingRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillingAdapter implements BillingPort {

    @Autowired
    private BillingRepository billingRepository;

    @Override
    public void generateBill(Billing billing) throws Exception {
        billingRepository.save(BillingMapper.toEntity(billing));
    }

    @Override
    public void updateBill(long billingId, Billing updatedBilling) throws Exception {
        BillingEntity existing = billingRepository.findById(billingId)
                .orElseThrow(() -> new Exception("Factura no encontrada con ID: " + billingId));

        BillingEntity updated = BillingMapper.toEntity(updatedBilling);
        updated.setId(existing.getId());
        billingRepository.save(updated);
    }

    @Override
    public Billing searchBillingById(long billingId) throws Exception {
        BillingEntity entity = billingRepository.findById(billingId)
                .orElseThrow(() -> new Exception("Factura no encontrada con ID: " + billingId));
        return BillingMapper.toDomain(entity);
    }

    @Override
    public List<Billing> listAllBillings() throws Exception {
        return billingRepository.findAll().stream()
                .map(BillingMapper::toDomain)
                .collect(Collectors.toList());
    }
}
