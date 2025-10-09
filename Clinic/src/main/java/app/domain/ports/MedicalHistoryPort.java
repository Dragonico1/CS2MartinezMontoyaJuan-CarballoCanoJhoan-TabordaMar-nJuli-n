package app.domain.ports;

import app.domain.model.MedicalHistory;
import java.util.List;

/**
 *
 * @author Dragonico
 */
public interface MedicalHistoryPort {
    void registerMedicalHistory(MedicalHistory history) throws Exception;
    void updateMedicalHistory(String historyId, MedicalHistory updatedData) throws Exception;
    MedicalHistory searchMedicalHistoryById(String historyId) throws Exception;
    List<MedicalHistory> listAllMedicalHistories() throws Exception;
    
}
