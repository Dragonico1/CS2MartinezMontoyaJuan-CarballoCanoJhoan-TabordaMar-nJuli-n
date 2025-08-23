package app.domain.model;
/**
 *
 * @author Dragonico
 */
public class EmergencyContact {
    private String Name;
    private String Relation;
    private double PhoneNum;

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

    public double getPhoneNum() {
        return PhoneNum;
    }

    public void setPhoneNum(double PhoneNum) {
        this.PhoneNum = PhoneNum;
    }
    
}
