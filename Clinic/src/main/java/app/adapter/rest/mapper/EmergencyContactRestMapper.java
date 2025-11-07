package app.adapter.rest.mapper;

import org.springframework.stereotype.Component;
import app.adapter.rest.request.EmergencyContactRequest;
import app.adapter.rest.response.EmergencyContactResponse;
import app.domain.model.EmergencyContact;

@Component
public class EmergencyContactRestMapper {

    // -------------------- Request → Domain --------------------
    public EmergencyContact toDomain(EmergencyContactRequest request) {
        if (request == null) return null;

        EmergencyContact contact = new EmergencyContact();
        contact.setName(request.getName());
        contact.setPhoneNumber(request.getPhone());
        contact.setRelation(request.getRelationship());
        return contact;
    }

    // -------------------- Domain → Response --------------------
    public EmergencyContactResponse toResponse(EmergencyContact contact) {
        if (contact == null) return null;

        EmergencyContactResponse response = new EmergencyContactResponse();
        response.setName(contact.getName());
        response.setRelation(contact.getRelation());
        response.setPhoneNumber(contact.getPhoneNum());
        return response;
    }
}
