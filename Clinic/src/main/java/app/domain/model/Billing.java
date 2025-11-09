package app.domain.model;

/**
 *
 * @author Dragonico
 */
public class Billing {
    private String ID;
    private Patient patient;
    private Employee Doctor;
    private MedicalPolicy Policy;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Employee getDoctor() {
        return Doctor;
    }

    public void setDoctor(Employee Doctor) {
        this.Doctor = Doctor;
    }

    public MedicalPolicy getPolicy() {
        return Policy;
    }

    public void setPolicy(MedicalPolicy Policy) {
        this.Policy = Policy;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
    
    
}
