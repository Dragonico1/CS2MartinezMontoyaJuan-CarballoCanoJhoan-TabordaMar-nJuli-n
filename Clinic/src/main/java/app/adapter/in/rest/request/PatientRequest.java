package app.adapter.in.rest.request;

import java.time.LocalDate;
import app.domain.model.Emuns.Gender;

/**
 * DTO for patient registration and update requests.
 * This object represents the JSON received in HTTP requests.
 * 
 * @author Dragonico
 */
public class PatientRequest {

    private String name;
    private String id;
    private String mail;
    private String phoneNum;
    private String address;
    private LocalDate birthdate;
    private Gender gender;

    private String emergencyContactName;
    private String emergencyContactRelation;
    private String emergencyContactPhone;

    private String insureName;
    private String policyNumber;
    private boolean policyState;
    private LocalDate policyDuration;

    // ---------------- Getters and Setters ----------------

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }
    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public String getEmergencyContactRelation() {
        return emergencyContactRelation;
    }
    public void setEmergencyContactRelation(String emergencyContactRelation) {
        this.emergencyContactRelation = emergencyContactRelation;
    }

    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }
    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
    }

    public String getInsureName() {
        return insureName;
    }
    public void setInsureName(String insureName) {
        this.insureName = insureName;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }
    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public boolean isPolicyState() {
        return policyState;
    }
    public void setPolicyState(boolean policyState) {
        this.policyState = policyState;
    }

    public LocalDate getPolicyDuration() {
        return policyDuration;
    }
    public void setPolicyDuration(LocalDate policyDuration) {
        this.policyDuration = policyDuration;
    }
}
