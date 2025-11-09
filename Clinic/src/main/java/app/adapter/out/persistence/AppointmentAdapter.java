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

    // -------------------- CREAR CITA --------------------
    @Override
    public void scheduleAppointment(Appointment appointment) throws Exception {
        if (appointment == null) {
            throw new Exception("La cita no puede ser nula.");
        }
        AppointmentEntity entity = AppointmentMapper.toEntity(appointment);
        appointmentRepository.save(entity);
    }

    // -------------------- ACTUALIZAR CITA --------------------
    @Override
    public void updateAppointment(String appointmentId, Appointment updatedData) throws Exception {
        AppointmentEntity existing = appointmentRepository.findByAppointmentId(appointmentId);
        if (existing == null) {
            throw new Exception("No se encontró la cita con ID: " + appointmentId);
        }

        AppointmentEntity updatedEntity = AppointmentMapper.toEntity(updatedData);
        updatedEntity.setAppointmentId(existing.getAppointmentId()); // mantener el ID original
        appointmentRepository.save(updatedEntity);
    }

    // -------------------- CANCELAR CITA --------------------
    @Override
    public void cancelAppointment(String appointmentId) throws Exception {
        AppointmentEntity entity = appointmentRepository.findByAppointmentId(appointmentId);
        if (entity == null) {
            throw new Exception("No se encontró la cita con ID: " + appointmentId);
        }
        appointmentRepository.delete(entity);
    }

    // -------------------- BUSCAR POR ID --------------------
    @Override
    public Appointment searchAppointmentById(String appointmentId) throws Exception {
        AppointmentEntity entity = appointmentRepository.findByAppointmentId(appointmentId);
        if (entity == null) {
            throw new Exception("No se encontró la cita con ID: " + appointmentId);
        }
        return AppointmentMapper.toDomain(entity);
    }

    // -------------------- LISTAR TODAS --------------------
    @Override
    public List<Appointment> listAllAppointments() throws Exception {
        List<AppointmentEntity> entities = appointmentRepository.findAll();
        return entities.stream()
                .map(AppointmentMapper::toDomain)
                .collect(Collectors.toList());
    }

    // -------------------- LISTAR POR PACIENTE --------------------
    @Override
    public List<Appointment> listAppointmentsByPatient(String patientId) throws Exception {
        List<AppointmentEntity> entities = appointmentRepository.findByPatientId(patientId);
        return entities.stream()
                .map(AppointmentMapper::toDomain)
                .collect(Collectors.toList());
    }

}
