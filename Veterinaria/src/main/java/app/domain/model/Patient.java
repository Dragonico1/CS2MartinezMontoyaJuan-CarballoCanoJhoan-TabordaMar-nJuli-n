package app.domain.model;

import java.time.LocalDate;
import app.domain.model.Emuns.Gender;

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

    public void setBirthdate(LocalDate Birthdate) {
        this.Birthdate = Birthdate;
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
