package app.infrastructure.persistence.mapper;

import app.domain.model.MedicationOrder;
import app.infrastructure.persistence.entity.MedicationOrderEntity;

/**
 * Mapper for converting between MedicationOrder (domain)
 * and MedicationOrderEntity (persistence).
 * 
 * @author Dragonico
 */
public class MedicationOrderMapper {

    // -------------------- TO ENTITY --------------------
    public static MedicationOrderEntity toEntity(MedicationOrder domain) {
        if (domain == null) return null;

        MedicationOrderEntity entity = new MedicationOrderEntity();
        entity.setOrderNumber(domain.getOrderNumber());
        entity.setItemNumber(domain.getItemNumber());
        entity.setPatientId(domain.getPatientId());
        entity.setDoctorId(domain.getDoctorId());
        entity.setCreationDate(domain.getCreationDate());

        entity.setMedicineId(domain.getMedicineId());
        entity.setMedicineName(domain.getMedicineName());
        entity.setDose(domain.getDose());
        entity.setTreatmentDuration(domain.getTreatmentDuration());
        entity.setCost(domain.getCost());

        return entity;
    }

    // -------------------- TO DOMAIN --------------------
    public static MedicationOrder toDomain(MedicationOrderEntity entity) {
        if (entity == null) return null;

        MedicationOrder domain = new MedicationOrder();
        domain.setOrderNumber(entity.getOrderNumber());
        domain.setItemNumber(entity.getItemNumber());
        domain.setPatientId(entity.getPatientId());
        domain.setDoctorId(entity.getDoctorId());
        domain.setCreationDate(entity.getCreationDate());

        domain.setMedicineId(entity.getMedicineId());
        domain.setMedicineName(entity.getMedicineName());
        domain.setDose(entity.getDose());
        domain.setTreatmentDuration(entity.getTreatmentDuration());
        domain.setCost(entity.getCost());

        return domain;
    }
}
