package app.infrastructure.persistence.mapper;

import app.domain.model.DiagnosticAidOrder;
import app.infrastructure.persistence.entity.DiagnosticAidOrderEntity;

/**
 * Mapper for converting between DiagnosticAidOrder (domain) and DiagnosticAidOrderEntity (database entity).
 * Follows clean architecture mapping rules.
 * 
 * @author Dragonico
 */
public class DiagnosticAidOrderMapper {

    // -------------------- TO ENTITY --------------------
    public static DiagnosticAidOrderEntity toEntity(DiagnosticAidOrder domain) {
        if (domain == null) return null;

        DiagnosticAidOrderEntity entity = new DiagnosticAidOrderEntity();
        entity.setOrderNumber(domain.getOrderNumber());
        entity.setItemNumber(domain.getItemNumber());
        entity.setPatientId(domain.getPatientId());
        entity.setDoctorId(domain.getDoctorId());
        entity.setCreationDate(domain.getCreationDate());

        entity.setExamId(domain.getExamId());
        entity.setExamName(domain.getExamName());
        entity.setQuantity(domain.getQuantity());
        entity.setCost(domain.getCost());
        entity.setRequiresSpecialist(domain.isRequiresSpecialist());
        entity.setSpecialistType(domain.getSpecialistType());

        return entity;
    }

    // -------------------- TO DOMAIN --------------------
    public static DiagnosticAidOrder toDomain(DiagnosticAidOrderEntity entity) {
        if (entity == null) return null;

        DiagnosticAidOrder domain = new DiagnosticAidOrder();
        domain.setOrderNumber(entity.getOrderNumber());
        domain.setItemNumber(entity.getItemNumber());
        domain.setPatientId(entity.getPatientId());
        domain.setDoctorId(entity.getDoctorId());
        domain.setCreationDate(entity.getCreationDate());

        domain.setExamId(entity.getExamId());
        domain.setExamName(entity.getExamName());
        domain.setQuantity(entity.getQuantity());
        domain.setCost(entity.getCost());
        domain.setRequiresSpecialist(entity.isRequiresSpecialist());
        domain.setSpecialistType(entity.getSpecialistType());

        return domain;
    }
}
