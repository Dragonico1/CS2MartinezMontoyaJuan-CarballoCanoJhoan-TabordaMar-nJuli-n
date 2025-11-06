package app.adapter.out.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import app.domain.model.Appointment;
import app.domain.ports.AppointmentPort;
import app.infrastructure.persistence.entity.AppointmentEntity;
import app.infrastructure.persistence.mapper.AppointmentMapper;
import app.infrastructure.persistence.repository.AppointmentRepository;

@Service
public class AppointmentAdapter implements AppointmentPort {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public void scheduleAppointment(Appointment appointment) throws Exception {
        AppointmentEntity entity = AppointmentMapper.toEntity(appointment);
        appointmentRepository.save(entity);
    }

    @Override
    public void updateAppointment(String appointmentId, Appointment updatedData) throws Exception {
        AppointmentEntity existing = appointmentRepository.findByAppointmentId(appointmentId);
        if (existing == null) {
            throw new Exception("No se encontró la cita con ID: " + appointmentId);
        }
        AppointmentEntity updatedEntity = AppointmentMapper.toEntity(updatedData);
        appointmentRepository.save(updatedEntity);
    }

    @Override
    public void cancelAppointment(String appointmentId) throws Exception {
        AppointmentEntity entity = appointmentRepository.findByAppointmentId(appointmentId);
        if (entity == null) {
            throw new Exception("No se encontró la cita con ID: " + appointmentId);
        }
        appointmentRepository.delete(entity);
    }

    @Override
    public Appointment searchAppointmentById(String appointmentId) throws Exception {
        AppointmentEntity entity = appointmentRepository.findByAppointmentId(appointmentId);
        return AppointmentMapper.toDomain(entity);
    }

    @Override
    public List<Appointment> listAppointmentsByPatient(String patientId) throws Exception {
        List<AppointmentEntity> entities = appointmentRepository.findByPatientId(patientId);
        return entities.stream()
                .map(AppointmentMapper::toDomain)
                .collect(Collectors.toList());
    }
}
