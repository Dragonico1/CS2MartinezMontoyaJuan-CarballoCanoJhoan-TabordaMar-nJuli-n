package app.domain.model;

import java.time.LocalDate;

/**
 *
 * @author Dragonico
 */
public abstract class Order {
    private String orderNumber;  
    private String patientId;
    private String doctorId;
    private LocalDate creationDate;
    private int itemNumber;

    public String getOrderNumber() {
        return orderNumber;
    }

     public void setOrderNumber(String orderNumber) {
        if (orderNumber != null && orderNumber.length() > 6) {
            throw new IllegalArgumentException("Orden máximo 6 dígitos");
        }
        this.orderNumber = orderNumber;
    }

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

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }
    
}
