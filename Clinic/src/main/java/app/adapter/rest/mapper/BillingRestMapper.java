package app.adapter.rest.mapper;

import org.springframework.stereotype.Component;
import app.adapter.rest.request.BillingRequest;
import app.adapter.rest.response.BillingResponse;
import app.domain.model.Billing;
import app.domain.model.Employee;
import app.domain.model.Patient;
import app.domain.model.MedicalPolicy;

/**
 * Mapper que convierte entre BillingRequest/BillingResponse y Billing (dominio).
 * 
 * @author Dragonico
 */
@Component
public class BillingRestMapper {

    // -------------------- TO DOMAIN --------------------
    public Billing toDomain(BillingRequest request) {
        if (request == null) return null;

        Billing billing = new Billing();

        // Asignar paciente
        Patient patient = new Patient();
        patient.setId(request.getPatientId());
        billing.setPatient(patient);

        Employee doctor = new Employee();
        billing.setDoctor(doctor);

        MedicalPolicy policy = new MedicalPolicy();
        billing.setPolicy(policy);

        return billing;
    }

    // -------------------- TO RESPONSE --------------------
    public BillingResponse toResponse(Billing billing) {
        if (billing == null) return null;

        BillingResponse res = new BillingResponse();

        res.setBillingId(null);

        res.setPatientId(
            billing.getPatient() != null ? billing.getPatient().getID() : null
        );

        res.setDoctorId(
            billing.getDoctor() != null ? billing.getDoctor().getID() : null
        );

        res.setPolicyNumber(
            billing.getPolicy() != null ? billing.getPolicy().getPolicyNumber() : null
        );

        res.setAmount(null);
        res.setStatus(null);

        return res;
    }
}
