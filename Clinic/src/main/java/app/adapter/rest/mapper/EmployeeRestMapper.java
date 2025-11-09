package app.adapter.rest.mapper;

import org.springframework.stereotype.Component;
import app.adapter.rest.request.EmployeeRequest;
import app.adapter.rest.response.EmployeeResponse;
import app.domain.model.Employee;
import app.domain.model.Emuns.Role;

@Component
public class EmployeeRestMapper {

    // -------------------- Request → Domain --------------------
    public Employee toDomain(EmployeeRequest request) {
        if (request == null) return null;

        Employee employee = new Employee();
        employee.setId(request.getId());
        employee.setName(request.getName());
        employee.setmail(request.getMail());
        employee.setPhoneNum(request.getPhone());
        employee.setAddress(request.getAddress());
        employee.setUsername(request.getUsername());
        employee.setPassword(request.getPassword());

        if (request.getRole() != null) {
            try {
                employee.setRole(Role.valueOf(request.getRole().toUpperCase()));
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Rol inválido: " + request.getRole());
            }
        }

        return employee;
    }

    // -------------------- Domain → Response --------------------
    public EmployeeResponse toResponse(Employee employee) {
        if (employee == null) return null;

        EmployeeResponse response = new EmployeeResponse();
        response.setId(employee.getID());
        response.setName(employee.getName());
        response.setMail(employee.getMail());
        response.setPhone(employee.getPhoneNum());
        response.setAddress(employee.getAddress());
        response.setUsername(employee.getUsername());
        response.setRole(employee.getRole() != null ? employee.getRole().name() : null);

        return response;
    }
}
