package app.adapter.in.validators;

import java.time.LocalDate;

/**
 *
 * @author Dragonico
 */
public abstract class OrderValidator extends SimpleValidator {
    
    public String orderNumberValidator(String value) throws Exception {
        stringValidator("número de orden", value);
        if (!value.matches("\\d+")) {
            throw new Exception("El número de orden debe ser numérico");
        }
        if (value.length() > 6) {
            throw new Exception("El número de orden no puede superar los 6 dígitos");
        }
        return value;
    }
    
    public String patientIdValidator(String value) throws Exception {
        stringValidator("cédula del paciente", value);
        if (!value.matches("\\d{1,10}")) {
            throw new Exception("La cédula del paciente debe tener máximo 10 dígitos");
        }
        return value;
    }
    
    public String doctorIdValidator(String value) throws Exception {
        stringValidator("cédula del médico", value);
        if (!value.matches("\\d{1,10}")) {
            throw new Exception("La cédula del médico debe tener máximo 10 dígitos");
        }
        return value;
    }
    
    public LocalDate creationDateValidator(LocalDate date) throws Exception {
        if (date == null) {
            throw new Exception("La fecha de creación no puede ser nula");
        }
        if (date.isAfter(LocalDate.now())) {
            throw new Exception("La fecha de creación no puede ser futura");
        }
        return date;
    }
    
    public int itemNumberValidator(int item) throws Exception {
        if (item <= 0) {
            throw new Exception("El número de ítem debe ser mayor que 0");
        }
        return item;
    }
}

