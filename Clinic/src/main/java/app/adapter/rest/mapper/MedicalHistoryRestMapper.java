package app.adapter.rest.mapper;

import org.springframework.stereotype.Component;
import app.adapter.rest.request.MedicalHistoryRequest;
import app.adapter.rest.response.MedicalHistoryResponse;
import app.domain.model.Employee;
import app.domain.model.MedicalHistory;
import app.domain.model.Patient;

import java.time.LocalDate;

@Component
public class MedicalHistoryRestMapper {

    // -------------------- Request → Domain --------------------
    public MedicalHistory toDomain(MedicalHistoryRequest request) {
        if (request == null) return null;

        MedicalHistory history = new MedicalHistory();

        // Asignar fecha (usa la fecha actual si no se envía)
        history.setDate(request.getDate() != null ? request.getDate() : LocalDate.now());

        // Asignar doctor
        if (request.getDoctorId() != null) {
            Employee doctor = new Employee();
            doctor.setId(request.getDoctorId());
            history.setDoctor(doctor);
        }

        // Asignar paciente
        if (request.getPatientId() != null) {
            Patient patient = new Patient();
            patient.setId(request.getPatientId());
            history.setPatient(patient);
        }

        history.setReasonVisit(request.getReasonVisit());
        history.setSymptoms(request.getSymptoms());
        history.setDiagnosis(request.getDiagnosis());

        return history;
    }

    // -------------------- Domain → Response --------------------
    public MedicalHistoryResponse toResponse(MedicalHistory history) {
        if (history == null) return null;

        MedicalHistoryResponse response = new MedicalHistoryResponse();

        response.setDate(history.getDate());
        response.setDoctorId(
                history.getDoctor() != null ? history.getDoctor().getID() : null
        );
        response.setPatientId(
                history.getPatient() != null ? history.getPatient().getID() : null
        );
        response.setReasonVisit(history.getReasonVisit());
        response.setSymptoms(history.getSymptoms());
        response.setDiagnosis(history.getDiagnosis());

        return response;
    }
}
