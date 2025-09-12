package app.adapter.in.validators;

/**
 *
 * @author Dragonico
 */
public abstract class PersonValidator extends SimpleValidator {
    
    public String nameValidator(String value) throws Exception {
        return stringValidator("nombre de la persona", value);
    }
    
    public String idValidator(String value) throws Exception {
        stringValidator("cédula de la persona", value);
        if (value.length() > 10) {
            throw new Exception("La cédula no puede tener más de 10 dígitos");
        }
        return value;
    }
    
    public String mailValidator(String value) throws Exception {
        stringValidator("correo electrónico", value);
        if (!value.contains("@")) {
            throw new Exception("El correo debe contener @");
        }
        return value;
    }
    
    public String phoneValidator(String value) throws Exception {
        stringValidator("número de teléfono", value);
        if (!value.matches("\\d{10}")) {
            throw new Exception("El teléfono debe tener exactamente 10 dígitos");
        }
        return value;
    }
    
    public String addressValidator(String value) throws Exception {
        stringValidator("dirección de la persona", value);
        if (value.length() > 30) {
            throw new Exception("La dirección no puede superar los 30 caracteres");
        }
        return value;
    }
}
