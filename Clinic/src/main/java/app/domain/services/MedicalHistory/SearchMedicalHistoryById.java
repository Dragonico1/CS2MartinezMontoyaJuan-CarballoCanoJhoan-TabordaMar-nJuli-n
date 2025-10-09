package app.domain.services.medicalhistory;

import app.domain.model.MedicalHistory;
import app.domain.ports.MedicalHistoryPort;

/**
 * Service to search for a medical record by its ID
 * @author Dragonico
 */
public class SearchMedicalHistoryById {
    private final MedicalHistoryPort medicalHistoryPort;

    public SearchMedicalHistoryById(MedicalHistoryPort medicalHistoryPort) {
        this.medicalHistoryPort = medicalHistoryPort;
    }

    public MedicalHistory search(String historyId) throws Exception {
        if (historyId == null || historyId.isBlank())
            throw new Exception("El ID de la historia clínica no puede estar vacío");
        return medicalHistoryPort.searchMedicalHistoryById(historyId);
    }
}
