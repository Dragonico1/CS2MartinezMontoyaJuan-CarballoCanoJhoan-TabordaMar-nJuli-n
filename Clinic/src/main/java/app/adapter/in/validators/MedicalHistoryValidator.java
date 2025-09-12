package app.adapter.in.validators;

import java.time.LocalDate;

/**
 *
 * @author Dragonico
 */
public class MedicalHistoryValidator extends SimpleValidator {
    
    public LocalDate dateValidator(LocalDate value) throws Exception {
        if (value == null) {
            throw new Exception("La fecha de la historia clínica no puede ser nula");
        }
        if (value.isAfter(LocalDate.now())) {
            throw new Exception("La fecha de la historia clínica no puede ser futura");
        }
        return value;
    }
    
    public Object doctorValidator(Object doctor) throws Exception {
        if (doctor == null) {
            throw new Exception("La historia clínica debe estar asociada a un médico");
        }
        return doctor;
    }
    
    public String reasonVisitValidator(String value) throws Exception {
        return stringValidator("motivo de la consulta", value);
    }
    
    public String symptomsValidator(String value) throws Exception {
        return stringValidator("sintomatología del paciente", value);
    }
    
    public Object diagnosisValidator(Object diagnosis) throws Exception {
        if (diagnosis == null) {
            throw new Exception("La historia clínica debe contener un diagnóstico");
        }
        return diagnosis;
    }
}
