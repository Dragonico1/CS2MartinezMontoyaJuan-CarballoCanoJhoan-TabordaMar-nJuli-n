package app.infrastructure.persistence.mapper;

import app.domain.model.Patient;
import app.infrastructure.persistence.entity.PatientEntity;

/**
 * Mapper for converting between Patient (domain)
 * and PatientEntity (persistence).
 * 
 * @author Dragonico
 */
public class PatientMapper {

    // -------------------- TO ENTITY --------------------
    public static PatientEntity toEntity(Patient domain) {
        if (domain == null) return null;

        PatientEntity entity = new PatientEntity();
        entity.setPatientId(domain.getID());
        entity.setName(domain.getName());
        entity.setEmail(domain.getMail());
        entity.setPhoneNumber(domain.getPhoneNum());
        entity.setAddress(domain.getAddress());
        entity.setBirthDate(domain.getBirthdate());
        entity.setGender(GenderMapper.toEntity(domain.getGender()));

        if (domain.getEmergencyCon() != null) {
            entity.setEmergencyContact(EmergencyContactMapper.toEntity(domain.getEmergencyCon()));
        }

        if (domain.getPolicy() != null) {
            entity.setMedicalPolicy(MedicalPolicyMapper.toEntity(domain.getPolicy()));
        }

        return entity;
    }

    // -------------------- TO DOMAIN --------------------
    public static Patient toDomain(PatientEntity entity) {
        if (entity == null) return null;

        Patient domain = new Patient();
        domain.setId(entity.getPatientId());
        domain.setName(entity.getName());
        domain.setmail(entity.getEmail());
        domain.setPhoneNum(entity.getPhoneNumber());
        domain.setAddress(entity.getAddress());
        domain.setBirthDate(entity.getBirthDate());
        domain.setGender(GenderMapper.toDomain(entity.getGender()));

        if (entity.getEmergencyContact() != null) {
            domain.setEmergencyCon(EmergencyContactMapper.toDomain(entity.getEmergencyContact()));
        }

        if (entity.getMedicalPolicy() != null) {
            domain.setPolicy(MedicalPolicyMapper.toDomain(entity.getMedicalPolicy()));
        }

        return domain;
    }
}
