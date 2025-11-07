package app.adapter.rest.mapper;

import org.springframework.stereotype.Component;
import app.adapter.rest.request.PatientRequest;
import app.adapter.rest.response.PatientResponse;
import app.domain.model.Patient;
import app.domain.model.Emuns.Gender;

import java.time.LocalDate;

@Component
public class PatientRestMapper {

    // -------------------- Request → Domain --------------------
    public Patient toDomain(PatientRequest request) {
        if (request == null) return null;

        Patient patient = new Patient();
        patient.setId(request.getId());
        patient.setName(request.getName());
        patient.setmail(request.getMail());
        patient.setPhoneNum(request.getPhone());
        patient.setAddress(request.getAddress());

        // Convertir String a LocalDate
        if (request.getBirthdate() != null && !request.getBirthdate().isEmpty()) {
            patient.setBirthDate(LocalDate.parse(request.getBirthdate()));
        }

        // Convertir String a enum Gender
        if (request.getGender() != null) {
            try {
                patient.setGender(Gender.valueOf(request.getGender().toUpperCase()));
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Género inválido: " + request.getGender());
            }
        }

        // Nota: EmergencyContact y Policy se gestionan en otros contextos (por IDs o mappers dedicados)
        return patient;
    }

    // -------------------- Domain → Response --------------------
    public PatientResponse toResponse(Patient patient) {
        if (patient == null) return null;

        PatientResponse response = new PatientResponse();
        response.setId(patient.getID());
        response.setName(patient.getName());
        response.setMail(patient.getMail());
        response.setPhoneNum(patient.getPhoneNum());
        response.setAddress(patient.getAddress());
        response.setBirthdate(patient.getBirthdate());
        response.setGender(patient.getGender() != null ? patient.getGender().name() : null);

        return response;
    }
}
