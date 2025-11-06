package app.adapter.in.validators;

import java.time.LocalDate;
import org.springframework.stereotype.Component;

/**
 *
 * @author Dragonico
 */
@Component
public class MedicalPolicyValidator extends SimpleValidator {
    
    public String insureNameValidator(String value) throws Exception {
        return stringValidator("nombre de la aseguradora", value);
    }
    
    public String policyNumberValidator(String value) throws Exception {
        stringValidator("número de póliza", value);
        if (!value.matches("\\d+")) {
            throw new Exception("El número de póliza debe ser numérico");
        }
        if (value.length() > 6) {
            throw new Exception("El número de póliza no puede superar los 6 dígitos");
        }
        return value;
    }
    
    public boolean stateValidator(boolean state) throws Exception {
        return state;
    }
    
    public LocalDate policyDurationValidator(LocalDate value, boolean state) throws Exception {
        if (value == null) {
            throw new Exception("La vigencia de la póliza no puede ser nula");
        }
        if (state && value.isBefore(LocalDate.now())) {
            throw new Exception("La póliza activa no puede tener una vigencia expirada");
        }
        return value;
    }
}
