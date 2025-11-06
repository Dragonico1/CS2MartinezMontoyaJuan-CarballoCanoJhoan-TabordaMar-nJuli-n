package app.adapter.in.validators;

import org.springframework.stereotype.Component;

/**
 *
 * @author Dragonico
 */
@Component
public class MedicationOrderValidator extends OrderValidator {
    
    public String medicineIdValidator(String value) throws Exception {
        stringValidator("ID del medicamento", value);
        if (!value.matches("\\d+")) {
            throw new Exception("El ID del medicamento debe ser numérico");
        }
        if (value.length() > 6) {
            throw new Exception("El ID del medicamento no puede superar los 6 dígitos");
        }
        return value;
    }
    
    public String medicineNameValidator(String value) throws Exception {
        return stringValidator("nombre del medicamento", value);
    }
    
    public String doseValidator(String value) throws Exception {
        return stringValidator("dosis del medicamento", value);
    }
    
    public String treatmentDurationValidator(String value) throws Exception {
        return stringValidator("duración del tratamiento", value);
    }
    
    public double costValidator(double value) throws Exception {
        if (value <= 0) {
            throw new Exception("El costo del medicamento debe ser mayor a 0");
        }
        return value;
    }
}

