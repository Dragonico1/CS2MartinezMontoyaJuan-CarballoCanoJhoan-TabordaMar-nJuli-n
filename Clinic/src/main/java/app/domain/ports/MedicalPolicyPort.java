package app.domain.ports;

import app.domain.model.MedicalPolicy;

/**
 *
 * @author Dragonico
 */
public interface MedicalPolicyPort {
    void assignPolicyToPatient(String patientId, MedicalPolicy policy)throws Exception;
    boolean isPolicyActive(String policyId)throws Exception;
    
}
