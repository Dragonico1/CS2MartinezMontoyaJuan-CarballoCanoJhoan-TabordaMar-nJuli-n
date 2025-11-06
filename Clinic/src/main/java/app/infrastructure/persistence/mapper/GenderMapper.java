package app.infrastructure.persistence.mapper;

import app.domain.model.Emuns.Gender;
import app.infrastructure.persistence.entity.GenderEntity;

public class GenderMapper {

    public static GenderEntity toEntity(Gender gender) {
        if (gender == null) return null;
        switch (gender) {
            case MALE: return GenderEntity.MALE;
            case FEMALE: return GenderEntity.FEMALE;
            default: return null;
        }
    }

    public static Gender toDomain(GenderEntity entityGender) {
        if (entityGender == null) return null;
        switch (entityGender) {
            case MALE: return Gender.MALE;
            case FEMALE: return Gender.FEMALE;
            default: return null;
        }
    }
}
