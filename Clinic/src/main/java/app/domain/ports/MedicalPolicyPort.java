package app.domain.ports;

import app.domain.model.MedicalPolicy;
import java.util.List;

/**
 *
 * @author Dragonico
 */
public interface MedicalPolicyPort {
    void registerMedicalPolicy(MedicalPolicy policy) throws Exception;
    void updateMedicalPolicy(String policyId, MedicalPolicy updatedData) throws Exception;
    void removeMedicalPolicy(String policyId) throws Exception;
    MedicalPolicy searchMedicalPolicyById(String policyId) throws Exception;
    boolean isPolicyActive(String policyId) throws Exception;
    List<MedicalPolicy> listAllPolicies() throws Exception;
    void assignPolicyToPatient(String patientId, MedicalPolicy policy) throws Exception;
}
