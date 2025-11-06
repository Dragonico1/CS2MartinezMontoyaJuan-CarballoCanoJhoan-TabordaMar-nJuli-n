package app.adapter.in.validators;

import org.springframework.stereotype.Component;

/**
 *
 * @author Dragonico
 */
@Component
public class ProcedureOrderValidator extends OrderValidator {
    
    public String procedureIdValidator(String value) throws Exception {
        stringValidator("ID del procedimiento", value);
        if (!value.matches("\\d+")) {
            throw new Exception("El ID del procedimiento debe ser numérico");
        }
        if (value.length() > 6) {
            throw new Exception("El ID del procedimiento no puede superar los 6 dígitos");
        }
        return value;
    }
    
    public String procedureNameValidator(String value) throws Exception {
        return stringValidator("nombre del procedimiento", value);
    }
    
    public int repetitionsValidator(int value) throws Exception {
        if (value <= 0) {
            throw new Exception("Las repeticiones deben ser mayores a 0");
        }
        return value;
    }
    
    public String frequencyValidator(String value) throws Exception {
        return stringValidator("frecuencia del procedimiento", value);
    }
    
    public double costValidator(double value) throws Exception {
        if (value <= 0) {
            throw new Exception("El costo del procedimiento debe ser mayor a 0");
        }
        return value;
    }
    
    public boolean requiresSpecialistValidator(boolean value, String specialistType) throws Exception {
        if (value && (specialistType == null || specialistType.isEmpty())) {
            throw new Exception("Si el procedimiento requiere especialista, debe especificar el tipo");
        }
        return value;
    }
    
    public String specialistTypeValidator(String value, boolean requiresSpecialist) throws Exception {
        if (requiresSpecialist) {
            return stringValidator("tipo de especialista", value);
        }
        return value;
    }
}
