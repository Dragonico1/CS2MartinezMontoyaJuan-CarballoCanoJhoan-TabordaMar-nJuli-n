package app.domain.model;
/**
 *
 * @author Dragonico
 */
public abstract class Person {
    private String Name;
    private double ID;
    private String Mail;
    private String PhoneNum;
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

    public void setmail(String Mail) {
        // Validación básica: debe contener @ y dominio
        if (Mail != null && !Mail.contains("@")) {
            throw new IllegalArgumentException("Email debe contener @");
        }
        this.Mail = Mail;
    }

    public String getPhoneNum() {
        return PhoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        // Validación básica: exactamente 10 dígitos
        if (phoneNum != null && !phoneNum.matches("\\d{10}")) {
            throw new IllegalArgumentException("Teléfono debe tener 10 dígitos");
        }
        this.PhoneNum = phoneNum;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
    
}


