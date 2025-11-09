package app.adapter.out.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import app.domain.model.EmergencyContact;
import app.domain.ports.EmergencyContactPort;
import app.infrastructure.persistence.entity.EmergencyContactEntity;
import app.infrastructure.persistence.mapper.EmergencyContactMapper;
import app.infrastructure.persistence.repository.EmergencyContactRepository;

@Service
public class EmergencyContactAdapter implements EmergencyContactPort {

    @Autowired
    private EmergencyContactRepository emergencyContactRepository;

    @Override
    public void registerEmergencyContact(EmergencyContact contact) throws Exception {
        emergencyContactRepository.save(EmergencyContactMapper.toEntity(contact));
    }

    @Override
    public void updateEmergencyContact(long contactId, EmergencyContact updatedData) throws Exception {
        String id = String.valueOf(contactId); // 🔁 conversión de long → String

        EmergencyContactEntity existing = emergencyContactRepository.findById(id)
                .orElseThrow(() -> new Exception("No se encontró el contacto de emergencia con ID: " + id));

        EmergencyContactEntity updated = EmergencyContactMapper.toEntity(updatedData);
        updated.setContactId(existing.getContactId());
        emergencyContactRepository.save(updated);
    }

    @Override
    public void removeEmergencyContact(String contactId) throws Exception {
        if (!emergencyContactRepository.existsById(contactId)) {
            throw new Exception("No se puede eliminar: contacto de emergencia no encontrado con ID: " + contactId);
        }
        emergencyContactRepository.deleteById(contactId);
}

    @Override
    public EmergencyContact searchEmergencyContactById(long contactId) throws Exception {
        String id = String.valueOf(contactId); // 🔁 conversión de long → String

        EmergencyContactEntity entity = emergencyContactRepository.findById(id)
                .orElseThrow(() -> new Exception("No se encontró el contacto de emergencia con ID: " + id));

        return EmergencyContactMapper.toDomain(entity);
    }

    @Override
    public List<EmergencyContact> listAllEmergencyContacts() throws Exception {
        return emergencyContactRepository.findAll()
                .stream()
                .map(EmergencyContactMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void assignEmergencyContact(String patientId, EmergencyContact contact) throws Exception {
        // En una implementación real, se agregaría una relación con PatientEntity
        EmergencyContactEntity entity = EmergencyContactMapper.toEntity(contact);
        entity.setPatientId(patientId);
        emergencyContactRepository.save(entity);
    }
}
