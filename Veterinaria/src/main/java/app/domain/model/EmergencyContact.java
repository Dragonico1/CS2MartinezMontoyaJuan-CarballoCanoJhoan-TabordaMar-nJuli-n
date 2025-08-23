package app.domain.model;
/**
 *
 * @author Dragonico
 */
public class EmergencyContact {
    private String Name;
    private String Relation;
    private String PhoneNum;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getRelation() {
        return Relation;
    }

    public void setRelation(String Relation) {
        this.Relation = Relation;
    }

    public String getPhoneNum() {
        return PhoneNum;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber != null && !phoneNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("Teléfono debe tener 10 dígitos");
        }
        this.PhoneNum = phoneNumber;
    }
    
}
