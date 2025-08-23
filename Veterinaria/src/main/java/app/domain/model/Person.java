package app.domain.model;
/**
 *
 * @author Dragonico
 */
public abstract class Person {
    private String Name;
    private String ID;
    private String Mail;
    private String PhoneNum;
    private String Address;
    
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getID() {
        return ID;
    }

    public void setId(String personId) {
        // Validación básica: máximo 10 dígitos
        if (personId != null && personId.length() > 10) {
            throw new IllegalArgumentException("Cédula médico máximo 10 dígitos");
        }
        this.ID = personId;
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

    public void setAddress(String address) {
        if (address != null && address.length() > 30) {
            throw new IllegalArgumentException("Dirección máximo 30 caracteres");
        }
        this.Address = address;
    }
    
}


