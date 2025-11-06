package app.infrastructure.persistence.mapper;

import app.domain.model.EmergencyContact;
import app.infrastructure.persistence.entity.EmergencyContactEntity;

/**
 * Mapper class to convert between EmergencyContact (domain)
 * and EmergencyContactEntity (persistence).
 * 
 * @author Dragonico
 */
public class EmergencyContactMapper {

    // -------------------- TO ENTITY --------------------
    public static EmergencyContactEntity toEntity(EmergencyContact domain) {
        if (domain == null) return null;

        EmergencyContactEntity entity = new EmergencyContactEntity();
        entity.setName(domain.getName());
        entity.setRelation(domain.getRelation());
        entity.setPhoneNumber(domain.getPhoneNum());
        return entity;
    }

    // -------------------- TO DOMAIN --------------------
    public static EmergencyContact toDomain(EmergencyContactEntity entity) {
        if (entity == null) return null;

        EmergencyContact domain = new EmergencyContact();
        domain.setName(entity.getName());
        domain.setRelation(entity.getRelation());
        domain.setPhoneNumber(entity.getPhoneNumber());
        return domain;
    }
}
