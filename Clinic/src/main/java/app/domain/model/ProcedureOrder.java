package app.domain.model;

/**
 *
 * @author Dragonico
 */
public class ProcedureOrder extends Order {
    private String ProduceID;
    private String ProcedureName;
    private int Repetitions;
    private String Frequency;
    private double Cost;
    private boolean RequiresSpecialist;
    private String SpecialistType;

    public String getProduceID() {
        return ProduceID;
    }

    public void setProduceID(String ProduceID) {
        this.ProduceID = ProduceID;
    }

    public String getProcedureName() {
        return ProcedureName;
    }

    public void setProcedureName(String ProcedureName) {
        this.ProcedureName = ProcedureName;
    }

    public int getRepetitions() {
        return Repetitions;
    }

    public void setRepetitions(int Repetitions) {
        this.Repetitions = Repetitions;
    }

    public String getFrequency() {
        return Frequency;
    }

    public void setFrequency(String Frequency) {
        this.Frequency = Frequency;
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
