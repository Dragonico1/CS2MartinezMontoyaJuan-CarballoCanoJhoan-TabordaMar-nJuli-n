package app.domain.model;

/**
 *
 * @author Dragonico
 */
public class MedicationOrder extends Order{
    private String MedicineId;
    private String MedicineName;
    private String Dose;
    private String TreatmentDuration;
    private double Cost;

    public String getMedicineId() {
        return MedicineId;
    }

    public void setMedicineId(String MedicineId) {
        this.MedicineId = MedicineId;
    }

    public String getMedicineName() {
        return MedicineName;
    }

    public void setMedicineName(String MedicineName) {
        this.MedicineName = MedicineName;
    }

    public String getDose() {
        return Dose;
    }

    public void setDose(String Dose) {
        this.Dose = Dose;
    }

    public String getTreatmentDuration() {
        return TreatmentDuration;
    }

    public void setTreatmentDuration(String TreatmentDuration) {
        this.TreatmentDuration = TreatmentDuration;
    }

    public double getCost() {
        return Cost;
    }

    public void setCost(double Cost) {
        this.Cost = Cost;
    }
    
}
