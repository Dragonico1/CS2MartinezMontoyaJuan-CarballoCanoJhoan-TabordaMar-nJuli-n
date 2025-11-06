package app.adapter.in.validators;
import org.springframework.stereotype.Component;

/**
 *
 * @author Dragonico
 */

@Component
public class DiagnosticAidOrderValidator extends OrderValidator {
    
    public String examIdValidator(String value) throws Exception {
        stringValidator("ID del examen", value);
        if (!value.matches("\\d+")) {
            throw new Exception("El ID del examen debe ser numérico");
        }
        if (value.length() > 6) {
            throw new Exception("El ID del examen no puede superar los 6 dígitos");
        }
        return value;
    }
    
    public String examNameValidator(String value) throws Exception {
        return stringValidator("nombre del examen", value);
    }
    
    public int quantityValidator(int value) throws Exception {
        if (value <= 0) {
            throw new Exception("La cantidad del examen debe ser mayor a 0");
        }
        return value;
    }
    
    public double costValidator(double value) throws Exception {
        if (value <= 0) {
            throw new Exception("El costo del examen debe ser mayor a 0");
        }
        return value;
    }
    
    public boolean requiresSpecialistValidator(boolean value, String specialistType) throws Exception {
        if (value && (specialistType == null || specialistType.isEmpty())) {
            throw new Exception("Si la ayuda diagnóstica requiere especialista, debe especificar el tipo");
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
