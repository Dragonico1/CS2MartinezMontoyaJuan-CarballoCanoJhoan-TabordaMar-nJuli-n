package app.infrastructure.persistence.mapper;

import app.domain.model.MedicalPolicy;
import app.infrastructure.persistence.entity.MedicalPolicyEntity;

/**
 * Mapper for converting between MedicalPolicy (domain)
 * and MedicalPolicyEntity (persistence).
 * 
 * @author Dragonico
 */
public class MedicalPolicyMapper {

    // -------------------- TO ENTITY --------------------
    public static MedicalPolicyEntity toEntity(MedicalPolicy domain) {
        if (domain == null) return null;

        MedicalPolicyEntity entity = new MedicalPolicyEntity();
        entity.setPolicyNumber(domain.getPolicyNumber());
        entity.setInsureName(domain.getInsureName());
        entity.setState(domain.isState());
        entity.setPolicyDuration(domain.getPolicyDuration());
        return entity;
    }

    // -------------------- TO DOMAIN --------------------
    public static MedicalPolicy toDomain(MedicalPolicyEntity entity) {
        if (entity == null) return null;

        MedicalPolicy domain = new MedicalPolicy();
        domain.setPolicyNumber(entity.getPolicyNumber());
        domain.setInsureName(entity.getInsureName());
        domain.setState(entity.isState());
        domain.setPolicyDuration(entity.getPolicyDuration());
        return domain;
    }
}
