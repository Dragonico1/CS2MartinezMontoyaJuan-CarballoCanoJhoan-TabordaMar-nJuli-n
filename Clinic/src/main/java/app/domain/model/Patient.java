package app.domain.model;

import java.time.LocalDate;
import app.domain.model.Emuns.Gender;
import java.time.Period;

/**
 *
 * @author Dragonico
 */
public class Patient extends Person{
    private LocalDate Birthdate;
    private Gender gender;
    private EmergencyContact emergencyCon;
    private MedicalPolicy Policy;

    public LocalDate getBirthdate() {
        return Birthdate;
    }

    public void setBirthDate(LocalDate birthDate) {
        // Validación básica: máximo 150 años
        if (birthDate != null) {
            int edad = Period.between(birthDate, LocalDate.now()).getYears();
            if (edad > 150) {
                throw new IllegalArgumentException("Edad máximo 150 años");
            }
        }
        this.Birthdate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public EmergencyContact getEmergencyCon() {
        return emergencyCon;
    }

    public void setEmergencyCon(EmergencyContact emergencyCon) {
        this.emergencyCon = emergencyCon;
    }

    public MedicalPolicy getPolicy() {
        return Policy;
    }

    public void setPolicy(MedicalPolicy Policy) {
        this.Policy = Policy;
    }
    
}
