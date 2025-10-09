package app.adapter.in.builder;

import org.springframework.stereotype.Component;
import app.domain.model.EmergencyContact;
import app.adapter.in.validators.EmergencyContactValidator;

/**
 * Builder for EmergencyContact objects.
 * Validates input fields using EmergencyContactValidator.
 * 
 * @author Dragonico
 */
@Component
public class EmergencyContactBuilder {

    private final EmergencyContactValidator validator = new EmergencyContactValidator();

    public EmergencyContact build(String name, String relation, String phone) throws Exception {
        EmergencyContact contact = new EmergencyContact();

        contact.setName(validator.nameValidator(name));
        contact.setRelation(validator.relationValidator(relation));
        contact.setPhoneNumber(validator.phoneValidator(phone));

        return contact;
    }
}
