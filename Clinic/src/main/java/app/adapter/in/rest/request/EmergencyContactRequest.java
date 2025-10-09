package app.adapter.in.rest.request;

/**
 * Request object for emergency contact registration or update.
 * Used by the Administrative staff controller.
 * 
 * @author Dragonico
 */
public class EmergencyContactRequest {

    private String name;
    private String relation;
    private String phone;
    private String patientId; // ID del paciente al que pertenece este contacto

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
}
