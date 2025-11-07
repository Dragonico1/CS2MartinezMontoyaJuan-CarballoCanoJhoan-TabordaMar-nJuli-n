package app.adapter.rest.request;

/**
 * Request para registrar o actualizar pacientes.
 * Usado por el controlador administrativo.
 * 
 * @author Dragonico
 */
public class PatientRequest {
    private String id;
    private String name;
    private String mail;
    private String phone;
    private String address;
    private String birthdate;
    private String gender;

    // Getters & Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getMail() { return mail; }
    public void setMail(String mail) { this.mail = mail; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getBirthdate() { return birthdate; }
    public void setBirthdate(String birthdate) { this.birthdate = birthdate; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
}
