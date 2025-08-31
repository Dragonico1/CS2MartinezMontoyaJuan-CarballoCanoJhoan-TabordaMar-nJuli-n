package app.application.usecases;

import app.domain.model.MedicalPolicy;
import app.domain.services.medicalpolicy.AssignPolicyToPatient;
import app.domain.services.medicalpolicy.CheckPolicyStatus;

/**
 *
 * @author Dragonico
 */
public class MedicalPolicyUseCase {

    private final AssignPolicyToPatient assignPolicyToPatient;
    private final CheckPolicyStatus checkPolicyStatus;

    public MedicalPolicyUseCase(AssignPolicyToPatient assignPolicyToPatient,
                                CheckPolicyStatus checkPolicyStatus) {
        this.assignPolicyToPatient = assignPolicyToPatient;
        this.checkPolicyStatus = checkPolicyStatus;
    }

    public void assignToPatient(String patientId, MedicalPolicy policy) throws Exception {
        assignPolicyToPatient.assign(patientId, policy);
    }

    public boolean isActive(String policyId) throws Exception {
        return checkPolicyStatus.isActive(policyId);
    }
}
