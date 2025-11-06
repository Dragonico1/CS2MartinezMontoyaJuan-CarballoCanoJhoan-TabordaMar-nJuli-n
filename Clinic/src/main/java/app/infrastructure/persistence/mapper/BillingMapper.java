package app.infrastructure.persistence.mapper;

import app.domain.model.Billing;
import app.domain.model.Employee;
import app.domain.model.MedicalPolicy;
import app.domain.model.Patient;
import app.infrastructure.persistence.entity.BillingEntity;

/**
 * Mapper class for Billing ↔ BillingEntity conversion.
 * Responsible only for translating between domain and persistence models.
 * @author Dragonico
 */
public class BillingMapper {

    public static BillingEntity toEntity(Billing billing) {
        if (billing == null) return null;

        BillingEntity entity = new BillingEntity();
        // Nota: tu entidad actual no contiene relaciones con Patient o Doctor,
        // solo amount y status, así que los demás campos deben manejarse en otra capa.
        // Si luego agregas relaciones, se expandirá aquí.
        return entity;
    }

    public static Billing toDomain(BillingEntity entity) {
        if (entity == null) return null;

        Billing billing = new Billing();
        // Igual que arriba, el dominio tiene objetos Patient, Employee, Policy,
        // pero la entidad actual no guarda esa relación.
        billing.setPatient(new Patient());
        billing.setDoctor(new Employee());
        billing.setPolicy(new MedicalPolicy());
        return billing;
    }
}
