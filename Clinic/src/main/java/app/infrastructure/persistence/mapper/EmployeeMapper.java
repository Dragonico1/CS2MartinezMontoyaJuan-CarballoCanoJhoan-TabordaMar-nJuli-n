package app.infrastructure.persistence.mapper;

import app.domain.model.Employee;
import app.domain.model.Emuns.Role;
import app.infrastructure.persistence.entity.EmployeeEntity;
import app.infrastructure.persistence.entity.RoleEntity;

/**
 * Mapper class to convert between Employee (domain)
 * and EmployeeEntity (persistence).
 * 
 * @author Dragonico
 */
public class EmployeeMapper {

    // -------------------- TO ENTITY --------------------
    public static EmployeeEntity toEntity(Employee domain) {
        if (domain == null) return null;

        EmployeeEntity entity = new EmployeeEntity();
        entity.setEmployeeId(domain.getID());
        entity.setName(domain.getName());
        entity.setEmail(domain.getMail());
        entity.setPhoneNumber(domain.getPhoneNum());
        entity.setAddress(domain.getAddress());
        entity.setUsername(domain.getUsername());
        entity.setPassword(domain.getPassword());
        entity.setRole(toEntityRole(domain.getRole()));

        return entity;
    }

    // -------------------- TO DOMAIN --------------------
    public static Employee toDomain(EmployeeEntity entity) {
        if (entity == null) return null;

        Employee domain = new Employee();
        domain.setId(entity.getEmployeeId());
        domain.setName(entity.getName());
        domain.setmail(entity.getEmail());
        domain.setPhoneNum(entity.getPhoneNumber());
        domain.setAddress(entity.getAddress());
        domain.setUsername(entity.getUsername());
        domain.setPassword(entity.getPassword());
        domain.setRole(toDomainRole(entity.getRole()));

        return domain;
    }

    // -------------------- ENUM CONVERSIONS --------------------
    private static RoleEntity toEntityRole(Role role) {
        if (role == null) return null;
        switch (role) {
            case HUMAN_RESOURCES: return RoleEntity.HUMAN_RESOURCES;
            case ADMIN_STAFF: return RoleEntity.ADMIN_STAFF;
            case INFO_SUPPORT: return RoleEntity.INFO_SUPPORT;
            case NURSE: return RoleEntity.NURSE;
            case DOCTOR: return RoleEntity.DOCTOR;
            default: return null;
        }
    }

    private static Role toDomainRole(RoleEntity entityRole) {
        if (entityRole == null) return null;
        switch (entityRole) {
            case HUMAN_RESOURCES: return Role.HUMAN_RESOURCES;
            case ADMIN_STAFF: return Role.ADMIN_STAFF;
            case INFO_SUPPORT: return Role.INFO_SUPPORT;
            case NURSE: return Role.NURSE;
            case DOCTOR: return Role.DOCTOR;
            default: return null;
        }
    }
}
