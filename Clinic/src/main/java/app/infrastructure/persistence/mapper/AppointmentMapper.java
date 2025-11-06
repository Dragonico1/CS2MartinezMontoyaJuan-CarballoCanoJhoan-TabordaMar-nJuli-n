package app.infrastructure.persistence.mapper;



import app.domain.model.Appointment;
import app.domain.model.Emuns.AppointmentStatus;
import app.infrastructure.persistence.entity.AppointmentEntity;
import app.infrastructure.persistence.entity.AppointmentStatusEntity;

public class AppointmentMapper {

    public static AppointmentEntity toEntity(Appointment appointment) {
        if (appointment == null) return null;

        AppointmentEntity entity = new AppointmentEntity();
        entity.setAppointmentId(appointment.getAppointmentId());
        entity.setPatientId(
            appointment.getPatient() != null ? appointment.getPatient().getID() : null
        );
        entity.setDoctorId(
            appointment.getDoctor() != null ? appointment.getDoctor().getID() : null
        );
        entity.setDateTime(appointment.getDateTime());
        entity.setReason(appointment.getReason());
        entity.setStatus(toEntityStatus(appointment.getStatus()));
        return entity;
    }

    public static Appointment toDomain(AppointmentEntity entity) {
        if (entity == null) return null;

        Appointment appointment = new Appointment();
        appointment.setAppointmentId(entity.getAppointmentId());
        appointment.setDateTime(entity.getDateTime());
        appointment.setReason(entity.getReason());
        appointment.setStatus(toDomainStatus(entity.getStatus()));
        // Los objetos Patient y Doctor pueden asignarse en el caso de uso si se necesitan
        return appointment;
    }

    private static AppointmentStatusEntity toEntityStatus(AppointmentStatus status) {
        if (status == null) return null;
        switch (status) {
            case PENDING: return AppointmentStatusEntity.SCHEDULED;
            case COMPLETED: return AppointmentStatusEntity.COMPLETED;
            case CANCELED: return AppointmentStatusEntity.CANCELLED;
            default: return AppointmentStatusEntity.SCHEDULED;
        }
    }

    private static AppointmentStatus toDomainStatus(AppointmentStatusEntity statusEntity) {
        if (statusEntity == null) return null;
        switch (statusEntity) {
            case SCHEDULED: return AppointmentStatus.PENDING;
            case COMPLETED: return AppointmentStatus.COMPLETED;
            case CANCELLED: return AppointmentStatus.CANCELED;
            default: return AppointmentStatus.PENDING;
        }
    }
}
