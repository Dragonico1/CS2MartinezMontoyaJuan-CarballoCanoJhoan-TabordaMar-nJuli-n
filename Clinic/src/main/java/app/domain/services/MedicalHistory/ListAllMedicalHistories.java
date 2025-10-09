package app.domain.services.medicalhistory;

import app.domain.model.MedicalHistory;
import app.domain.ports.MedicalHistoryPort;
import java.util.List;

/**
 *
 * @author Dragonico
 */
public class ListAllMedicalHistories {
    private final MedicalHistoryPort medicalHistoryPort;

    public ListAllMedicalHistories(MedicalHistoryPort medicalHistoryPort) {
        this.medicalHistoryPort = medicalHistoryPort;
    }

    public List<MedicalHistory> list() throws Exception {
        return medicalHistoryPort.listAllMedicalHistories();
    }
}
