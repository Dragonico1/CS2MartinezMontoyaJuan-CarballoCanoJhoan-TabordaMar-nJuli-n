package app.domain.model;

/**
 *
 * @author Dragonico
 */
public class DiagnosticAidOrder {
    private String ExamId;
    private String ExamName;
    private int Quantity;
    private double Cost;
    private boolean RequiresSpecialist;
    private String SpecialistType;

    public String getExamId() {
        return ExamId;
    }

    public void setExamId(String ExamId) {
        this.ExamId = ExamId;
    }

    public String getExamName() {
        return ExamName;
    }

    public void setExamName(String ExamName) {
        this.ExamName = ExamName;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public double getCost() {
        return Cost;
    }

    public void setCost(double Cost) {
        this.Cost = Cost;
    }

    public boolean isRequiresSpecialist() {
        return RequiresSpecialist;
    }

    public void setRequiresSpecialist(boolean RequiresSpecialist) {
        this.RequiresSpecialist = RequiresSpecialist;
    }

    public String getSpecialistType() {
        return SpecialistType;
    }

    public void setSpecialistType(String SpecialistType) {
        this.SpecialistType = SpecialistType;
    }
    
}
