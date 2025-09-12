package app.adapter.in.validators;

import java.time.LocalDate;
import java.time.Period;
import app.domain.model.Emuns.Gender;

/**
 *
 * @author Dragonico
 */
public class PatientValidator extends PersonValidator {
    
    public LocalDate birthdateValidator(LocalDate birthdate) throws Exception {
        if (birthdate == null) {
            throw new Exception("La fecha de nacimiento no puede ser nula");
        }
        int edad = Period.between(birthdate, LocalDate.now()).getYears();
        if (edad > 150) {
            throw new Exception("Edad máxima permitida es 150 años");
        }
        return birthdate;
    }
    
    public Gender genderValidator(Gender gender) throws Exception {
        if (gender == null) {
            throw new Exception("El género no puede ser nulo");
        }
        return gender;
    }
    
    public Object emergencyContactValidator(Object emergencyContact) throws Exception {
        if (emergencyContact == null) {
            throw new Exception("Debe existir al menos un contacto de emergencia");
        }
        return emergencyContact;
    }
    
    public Object medicalPolicyValidator(Object policy) throws Exception {
        if (policy == null) {
            throw new Exception("La póliza médica no puede ser nula");
        }
        return policy;
    }
}
