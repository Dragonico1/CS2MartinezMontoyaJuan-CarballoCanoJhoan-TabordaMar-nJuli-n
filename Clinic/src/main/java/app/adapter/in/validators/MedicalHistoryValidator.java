package app.adapter.in.validators;

import app.domain.model.Employee;
import app.domain.model.Patient;
import java.time.LocalDate;
import org.springframework.stereotype.Component;

/**
 * Validador para los campos del modelo MedicalHistory.
 * Verifica la coherencia de los datos clínicos antes de persistirlos.
 * 
 * @author Dragonico
 */
@Component
public class MedicalHistoryValidator extends SimpleValidator {
    
    public LocalDate dateValidator(LocalDate value) throws Exception {
        if (value == null) {
            throw new Exception("La fecha de la historia clínica no puede ser nula.");
        }
        if (value.isAfter(LocalDate.now())) {
            throw new Exception("La fecha de la historia clínica no puede ser futura.");
        }
        return value;
    }
    
    public Employee doctorValidator(Employee doctor) throws Exception {
        if (doctor == null) {
            throw new Exception("La historia clínica debe estar asociada a un médico responsable.");
        }
        return doctor;
    }

    public Patient patientValidator(Patient patient) throws Exception {
        if (patient == null) {
            throw new Exception("La historia clínica debe estar asociada a un paciente.");
        }
        return patient;
    }
    
    public String reasonVisitValidator(String value) throws Exception {
        return stringValidator("motivo de la consulta", value);
    }
    
    public String symptomsValidator(String value) throws Exception {
        return stringValidator("sintomatología del paciente", value);
    }
    
    public String diagnosisValidator(String value) throws Exception {
        return stringValidator("diagnóstico médico", value);
    }
}
