package app.adapter.rest.response;

public class EmergencyContactResponse {
    private Long contactId;
    private String name;
    private String relation;
    private String phoneNumber;
    private String patientId; // opcional

    public Long getContactId() { return contactId; }
    public void setContactId(Long contactId) { this.contactId = contactId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRelation() { return relation; }
    public void setRelation(String relation) { this.relation = relation; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }
}
