package app.infrastructure.persistence.mapper;

import app.domain.model.ProcedureOrder;
import app.infrastructure.persistence.entity.ProcedureOrderEntity;

/**
 * Mapper for converting between ProcedureOrder (domain)
 * and ProcedureOrderEntity (persistence).
 * 
 * @author Dragonico
 */
public class ProcedureOrderMapper {

    // -------------------- TO ENTITY --------------------
    public static ProcedureOrderEntity toEntity(ProcedureOrder domain) {
        if (domain == null) return null;

        ProcedureOrderEntity entity = new ProcedureOrderEntity();
        entity.setOrderNumber(domain.getOrderNumber());
        entity.setItemNumber(domain.getItemNumber());
        entity.setPatientId(domain.getPatientId());
        entity.setDoctorId(domain.getDoctorId());
        entity.setCreationDate(domain.getCreationDate());

        entity.setProcedureId(domain.getProduceID());
        entity.setProcedureName(domain.getProcedureName());
        entity.setRepetitions(domain.getRepetitions());
        entity.setFrequency(domain.getFrequency());
        entity.setCost(domain.getCost());
        entity.setRequiresSpecialist(domain.isRequiresSpecialist());
        entity.setSpecialistType(domain.getSpecialistType());

        return entity;
    }

    // -------------------- TO DOMAIN --------------------
    public static ProcedureOrder toDomain(ProcedureOrderEntity entity) {
        if (entity == null) return null;

        ProcedureOrder domain = new ProcedureOrder();
        domain.setOrderNumber(entity.getOrderNumber());
        domain.setItemNumber(entity.getItemNumber());
        domain.setPatientId(entity.getPatientId());
        domain.setDoctorId(entity.getDoctorId());
        domain.setCreationDate(entity.getCreationDate());

        domain.setProduceID(entity.getProcedureId());
        domain.setProcedureName(entity.getProcedureName());
        domain.setRepetitions(entity.getRepetitions());
        domain.setFrequency(entity.getFrequency());
        domain.setCost(entity.getCost());
        domain.setRequiresSpecialist(entity.isRequiresSpecialist());
        domain.setSpecialistType(entity.getSpecialistType());

        return domain;
    }
}
