package app.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Entity for DiagnosticAidOrder table in database
 * @author Dragonico
 */
@Entity
@Table(name = "diagnostic_aid_orders")
public class DiagnosticAidOrderEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "order_number", length = 6, nullable = false)
    private String orderNumber;
    
    @Column(name = "item_number", nullable = false)
    private int itemNumber;
    
    @Column(name = "patient_id", length = 10, nullable = false)
    private String patientId;
    
    @Column(name = "doctor_id", length = 10, nullable = false)
    private String doctorId;
    
    @Column(name = "creation_date", nullable = false)
    private LocalDate creationDate;
    
    @Column(name = "exam_id", nullable = false)
    private String examId;
    
    @Column(name = "exam_name", nullable = false)
    private String examName;
    
    @Column(name = "quantity", nullable = false)
    private int quantity;
    
    @Column(name = "cost", nullable = false)
    private double cost;
    
    @Column(name = "requires_specialist", nullable = false)
    private boolean requiresSpecialist;
    
    @Column(name = "specialist_type")
    private String specialistType;

    public DiagnosticAidOrderEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
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

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean isRequiresSpecialist() {
        return requiresSpecialist;
    }

    public void setRequiresSpecialist(boolean requiresSpecialist) {
        this.requiresSpecialist = requiresSpecialist;
    }

    public String getSpecialistType() {
        return specialistType;
    }

    public void setSpecialistType(String specialistType) {
        this.specialistType = specialistType;
    }
}