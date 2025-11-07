package app.adapter.rest.request;

/**
 * Request para registrar o actualizar un contacto de emergencia
 * asociado a un paciente.
 * 
 * @author Dragonico
 */
public class EmergencyContactRequest {

    private String name;
    private String phone;
    private String relationship;

    // ---------- Getters & Setters ----------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
}
