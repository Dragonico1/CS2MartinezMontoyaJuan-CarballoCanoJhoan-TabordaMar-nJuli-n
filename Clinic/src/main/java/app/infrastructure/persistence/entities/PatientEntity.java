package app.infrastructure.persistence.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Entity for Patient table in database
 * @author Dragonico
 */
@Entity
@Table(name = "patients")
public class PatientEntity {
    
    @Id
    @Column(name = "patient_id", length = 10, nullable = false)
    private String patientId;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "email", nullable = false)
    private String email;
    
    @Column(name = "phone_number", length = 10, nullable = false)
    private String phoneNumber;
    
    @Column(name = "address", length = 30)
    private String address;
    
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;
    
    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private GenderEntity gender;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emergency_contact_id")
    private EmergencyContactEntity emergencyContact;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "policy_id")
    private MedicalPolicyEntity medicalPolicy;

    public PatientEntity() {
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public GenderEntity getGender() {
        return gender;
    }

    public void setGender(GenderEntity gender) {
        this.gender = gender;
    }

    public EmergencyContactEntity getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(EmergencyContactEntity emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public MedicalPolicyEntity getMedicalPolicy() {
        return medicalPolicy;
    }

    public void setMedicalPolicy(MedicalPolicyEntity medicalPolicy) {
        this.medicalPolicy = medicalPolicy;
    }
}