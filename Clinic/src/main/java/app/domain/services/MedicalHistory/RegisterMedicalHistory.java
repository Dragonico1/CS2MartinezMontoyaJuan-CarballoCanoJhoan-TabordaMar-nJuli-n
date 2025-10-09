package app.domain.services.medicalhistory;

import app.domain.model.MedicalHistory;
import app.domain.ports.MedicalHistoryPort;

/**
 * 
 * @author Dragonico
 */
public class RegisterMedicalHistory {
    private final MedicalHistoryPort medicalHistoryPort;

    public RegisterMedicalHistory(MedicalHistoryPort medicalHistoryPort) {
        this.medicalHistoryPort = medicalHistoryPort;
    }

    public void register(MedicalHistory history) throws Exception {
        if (history == null)
            throw new Exception("La historia clínica no puede ser nula");
        medicalHistoryPort.registerMedicalHistory(history);
    }
}
