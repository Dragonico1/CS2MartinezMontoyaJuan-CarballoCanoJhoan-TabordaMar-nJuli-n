package app.infrastructure.persistence.entity;

import jakarta.persistence.*;

/**
 * Entity for EmergencyContact table in database.
 * Represents a patient's emergency contact.
 * 
 * @author Dragonico
 */
@Entity
@Table(name = "emergency_contacts")
public class EmergencyContactEntity {

    // -------------------- PRIMARY KEY --------------------
    @Id
    @Column(name = "contact_id", nullable = false, length = 10)
    private String contactId;

    // -------------------- ATTRIBUTES --------------------
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "relation", nullable = false, length = 50)
    private String relation;

    @Column(name = "phone_number", nullable = false, length = 15)
    private String phoneNumber;

    @Column(name = "patient_id", length = 10)
    private String patientId; 
    // ⚠️ Este campo es opcional: sirve si se quiere asociar a un paciente en la BD

    // -------------------- CONSTRUCTOR --------------------
    public EmergencyContactEntity() {
    }

    // -------------------- GETTERS & SETTERS --------------------
    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
}
