package app.adapter.rest.request;

/**
 * Request para registrar o actualizar una factura médica.
 * Contiene los datos necesarios enviados desde el cliente.
 * 
 * @author Dragonico
 */
public class BillingRequest {

    private Long id;
    private Double amount;
    private String status;
    private String patientId;
    private String appointmentId;

    // ---------- Getters & Setters ----------
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }
}
