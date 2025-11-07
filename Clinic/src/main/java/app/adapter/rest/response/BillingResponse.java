package app.adapter.rest.response;

public class BillingResponse {
    private String billingId; // si tienes id
    private String patientId;
    private String doctorId;
    private String policyNumber;
    private Double amount;
    private String status;

    public String getBillingId() { return billingId; }
    public void setBillingId(String billingId) { this.billingId = billingId; }

    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }

    public String getDoctorId() { return doctorId; }
    public void setDoctorId(String doctorId) { this.doctorId = doctorId; }

    public String getPolicyNumber() { return policyNumber; }
    public void setPolicyNumber(String policyNumber) { this.policyNumber = policyNumber; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
