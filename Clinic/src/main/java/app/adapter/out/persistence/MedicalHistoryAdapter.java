package app.adapter.out.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.MedicalHistory;
import app.domain.ports.MedicalHistoryPort;
import app.infrastructure.persistence.entity.MedicalHistoryEntity;
import app.infrastructure.persistence.mapper.MedicalHistoryMapper;
import app.infrastructure.persistence.repository.MedicalHistoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicalHistoryAdapter implements MedicalHistoryPort {

    @Autowired
    private MedicalHistoryRepository medicalHistoryRepository;

    @Override
    public void registerMedicalHistory(MedicalHistory history) throws Exception {
        if (history == null) throw new Exception("La historia clínica no puede ser nula");
        medicalHistoryRepository.save(MedicalHistoryMapper.toEntity(history));
    }

    @Override
    public void updateMedicalHistory(String historyId, MedicalHistory updatedData) throws Exception {
        MedicalHistoryEntity existing = medicalHistoryRepository.findById(historyId)
                .orElseThrow(() -> new Exception("Historia clínica no encontrada con ID: " + historyId));

        MedicalHistoryEntity updated = MedicalHistoryMapper.toEntity(updatedData);
        updated.setHistoryId(existing.getHistoryId());
        medicalHistoryRepository.save(updated);
    }

    @Override
    public MedicalHistory searchMedicalHistoryById(String historyId) throws Exception {
        MedicalHistoryEntity entity = medicalHistoryRepository.findById(historyId)
                .orElseThrow(() -> new Exception("Historia clínica no encontrada con ID: " + historyId));
        return MedicalHistoryMapper.toDomain(entity);
    }

    @Override
    public List<MedicalHistory> listAllMedicalHistories() throws Exception {
        return medicalHistoryRepository.findAll()
                .stream()
                .map(MedicalHistoryMapper::toDomain)
                .collect(Collectors.toList());
    }
}
