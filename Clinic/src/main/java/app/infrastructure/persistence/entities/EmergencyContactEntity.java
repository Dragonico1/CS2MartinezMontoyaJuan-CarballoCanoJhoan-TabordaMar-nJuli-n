package app.infrastructure.persistence.entities;

import jakarta.persistence.*;

/**
 * Entity for EmergencyContact table in database
 * @author Dragonico
 */
@Entity
@Table(name = "emergency_contacts")
public class EmergencyContactEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private Long contactId;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "relation", nullable = false)
    private String relation;
    
    @Column(name = "phone_number", length = 10, nullable = false)
    private String phoneNumber;

    public EmergencyContactEntity() {
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
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
}