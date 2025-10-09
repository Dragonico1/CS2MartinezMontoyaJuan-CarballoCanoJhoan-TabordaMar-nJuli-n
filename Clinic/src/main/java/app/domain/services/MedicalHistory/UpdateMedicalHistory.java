package app.domain.services.medicalhistory;

import app.domain.model.MedicalHistory;
import app.domain.ports.MedicalHistoryPort;

/**
 *
 * @author Dragonico
 */
public class UpdateMedicalHistory {
    private final MedicalHistoryPort medicalHistoryPort;

    public UpdateMedicalHistory(MedicalHistoryPort medicalHistoryPort) {
        this.medicalHistoryPort = medicalHistoryPort;
    }

    public void update(String historyId, MedicalHistory updatedData) throws Exception {
        if (historyId == null || historyId.isBlank())
            throw new Exception("El ID de la historia clínica no puede estar vacío");
        if (updatedData == null)
            throw new Exception("Los datos actualizados no pueden ser nulos");

        medicalHistoryPort.updateMedicalHistory(historyId, updatedData);
    }
}
