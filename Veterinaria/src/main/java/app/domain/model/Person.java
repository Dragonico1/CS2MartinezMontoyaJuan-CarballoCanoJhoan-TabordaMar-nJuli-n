package app.domain.model;
/**
 *
 * @author Dragonico
 */
public abstract class Person {
    private String Name;
    private double ID;
    private String Mail;
    private double PhoneNum;
    private String Address;
    
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getID() {
        return ID;
    }

    public void setID(double ID) {
        this.ID = ID;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }

    public double getPhoneNum() {
        return PhoneNum;
    }

    public void setPhoneNum(double PhoneNum) {
        this.PhoneNum = PhoneNum;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
    
}


