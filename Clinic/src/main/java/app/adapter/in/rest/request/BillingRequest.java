package app.adapter.in.rest.request;

/**
 * DTO para la creación de facturas médicas.
 * Contiene los identificadores de paciente, médico y número de póliza.
 * 
 * @author Dragonico
 */
public class BillingRequest {

    private String patientId;
    private String doctorId;
    private String policyNumber;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }
}
