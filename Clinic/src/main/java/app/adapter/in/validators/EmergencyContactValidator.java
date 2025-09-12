package app.adapter.in.validators;

/**
 *
 * @author Dragonico
 */
public class EmergencyContactValidator extends SimpleValidator {
    
    public String nameValidator(String value) throws Exception {
        return stringValidator("nombre del contacto de emergencia", value);
    }
    
    public String relationValidator(String value) throws Exception {
        return stringValidator("relación con el paciente", value);
    }
    
    public String phoneValidator(String value) throws Exception {
        stringValidator("teléfono del contacto de emergencia", value);
        if (!value.matches("\\d{10}")) {
            throw new Exception("El teléfono de contacto debe tener exactamente 10 dígitos");
        }
        return value;
    }
}
