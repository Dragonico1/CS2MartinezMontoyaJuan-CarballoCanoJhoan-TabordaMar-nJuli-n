package app.adapter.in.builder;

import org.springframework.stereotype.Component;
import app.adapter.in.rest.request.BillingRequest;
import app.domain.model.Billing;
import app.domain.model.Patient;
import app.domain.model.Employee;
import app.domain.model.MedicalPolicy;

/**
 * Construye un objeto Billing a partir de un BillingRequest.
 * Asigna las referencias de paciente, médico y póliza médica con base en sus datos básicos.
 * 
 * @author Dragonico
 */
@Component
public class BillingBuilder {

    public Billing build(BillingRequest request) throws Exception {
        if (request == null) {
            throw new Exception("La solicitud de facturación no puede ser nula.");
        }

        if (request.getPatientId() == null || request.getPatientId().isBlank()) {
            throw new Exception("El ID del paciente no puede estar vacío.");
        }
        if (request.getDoctorId() == null || request.getDoctorId().isBlank()) {
            throw new Exception("El ID del médico no puede estar vacío.");
        }
        if (request.getPolicyNumber() == null || request.getPolicyNumber().isBlank()) {
            throw new Exception("El número de póliza no puede estar vacío.");
        }

        Billing billing = new Billing();

        // Asignar paciente
        Patient patient = new Patient();
        patient.setId(request.getPatientId());
        billing.setPatient(patient);

        // Asignar médico
        Employee doctor = new Employee();
        doctor.setId(request.getDoctorId());
        billing.setDoctor(doctor);

        // Asignar póliza médica
        MedicalPolicy policy = new MedicalPolicy();
        try {
            double policyNumber = Double.parseDouble(request.getPolicyNumber());
            policy.setPolicyNumber(policyNumber);
        } catch (NumberFormatException e) {
            throw new Exception("El número de póliza debe ser un valor numérico.");
        }

        billing.setPolicy(policy);

        return billing;
    }
}
