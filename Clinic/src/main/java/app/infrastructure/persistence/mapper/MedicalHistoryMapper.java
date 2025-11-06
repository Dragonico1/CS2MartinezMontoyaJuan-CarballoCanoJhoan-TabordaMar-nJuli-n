package app.infrastructure.persistence.mapper;

import app.domain.model.MedicalHistory;
import app.domain.model.Employee;
import app.domain.model.Patient;
import app.infrastructure.persistence.entity.MedicalHistoryEntity;

/**
 * Mapper para convertir entre MedicalHistory (dominio)
 * y MedicalHistoryEntity (persistencia).
 * 
 * @author Dragonico
 */
public class MedicalHistoryMapper {

    // -------------------- TO ENTITY --------------------
    public static MedicalHistoryEntity toEntity(MedicalHistory domain) {
        if (domain == null) return null;

        MedicalHistoryEntity entity = new MedicalHistoryEntity();

        // ⚙️ IDs desde objetos dominio
        entity.setHistoryId(domain.getPatient() != null ? domain.getPatient().getID() + "_H" : null);
        entity.setPatientId(domain.getPatient() != null ? domain.getPatient().getID() : null);
        entity.setDoctorId(domain.getDoctor() != null ? domain.getDoctor().getID() : null);

        // 🔁 Campos simples
        entity.setDiagnosis(domain.getDiagnosis());
        entity.setTreatment(domain.getDiagnosis() != null ? "Tratamiento generado automáticamente" : null);
        entity.setCreationDate(domain.getDate());
        entity.setObservations(domain.getReasonVisit() != null ? domain.getReasonVisit() : "Sin observaciones");

        return entity;
    }

    // -------------------- TO DOMAIN --------------------
    public static MedicalHistory toDomain(MedicalHistoryEntity entity) {
        if (entity == null) return null;

        MedicalHistory domain = new MedicalHistory();

        // ⚙️ Construcción parcial de objetos relacionados
        Patient patient = new Patient();
        patient.setId(entity.getPatientId());

        Employee doctor = new Employee();
        doctor.setId(entity.getDoctorId());

        domain.setPatient(patient);
        domain.setDoctor(doctor);

        // 🔁 Campos simples
        domain.setDiagnosis(entity.getDiagnosis());
        domain.setDate(entity.getCreationDate());
        domain.setReasonVisit(entity.getObservations());
        domain.setSymptoms("No registrados en BD");

        return domain;
    }
}
