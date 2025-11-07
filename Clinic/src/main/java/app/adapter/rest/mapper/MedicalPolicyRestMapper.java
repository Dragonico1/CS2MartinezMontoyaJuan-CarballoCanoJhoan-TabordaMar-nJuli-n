package app.adapter.rest.mapper;

import org.springframework.stereotype.Component;
import app.adapter.rest.request.MedicalPolicyRequest;
import app.adapter.rest.response.MedicalPolicyResponse;
import app.domain.model.MedicalPolicy;

@Component
public class MedicalPolicyRestMapper {

    // -------------------- Request → Domain --------------------
    public MedicalPolicy toDomain(MedicalPolicyRequest request) {
        if (request == null) return null;

        MedicalPolicy policy = new MedicalPolicy();
        policy.setPolicyNumber(request.getPolicyNumber());
        policy.setInsureName(request.getInsureName());
        policy.setState(request.isState());
        policy.setPolicyDuration(request.getPolicyDuration());
        return policy;
    }

    // -------------------- Domain → Response --------------------
    public MedicalPolicyResponse toResponse(MedicalPolicy policy) {
        if (policy == null) return null;

        MedicalPolicyResponse response = new MedicalPolicyResponse();
        response.setPolicyNumber(policy.getPolicyNumber());
        response.setInsureName(policy.getInsureName());
        response.setState(policy.isState());
        response.setPolicyDuration(policy.getPolicyDuration() != null ? policy.getPolicyDuration().getYear() : 0);
        return response;
    }
}
