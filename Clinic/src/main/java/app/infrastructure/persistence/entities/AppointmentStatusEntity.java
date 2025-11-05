package app.infrastructure.persistence.entities;

/**
 * Enum for AppointmentStatus in database entity
 * @author Dragonico
 */
public enum AppointmentStatusEntity {
    SCHEDULED,
    CONFIRMED,
    IN_PROGRESS,
    COMPLETED,
    CANCELLED
}