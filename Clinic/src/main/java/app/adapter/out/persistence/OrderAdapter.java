package app.adapter.out.persistence;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Order;
import app.domain.model.MedicationOrder;
import app.domain.model.ProcedureOrder;
import app.domain.model.DiagnosticAidOrder;
import app.domain.ports.OrderPort;
import app.infrastructure.persistence.entity.MedicationOrderEntity;
import app.infrastructure.persistence.entity.ProcedureOrderEntity;
import app.infrastructure.persistence.entity.DiagnosticAidOrderEntity;
import app.infrastructure.persistence.mapper.MedicationOrderMapper;
import app.infrastructure.persistence.mapper.ProcedureOrderMapper;
import app.infrastructure.persistence.mapper.DiagnosticAidOrderMapper;
import app.infrastructure.persistence.repository.MedicationOrderRepository;
import app.infrastructure.persistence.repository.ProcedureOrderRepository;
import app.infrastructure.persistence.repository.DiagnosticAidOrderRepository;

/**
 * Adapter genérico que implementa OrderPort.
 * Detecta el tipo concreto de orden (Medicamento, Procedimiento, Ayuda diagnóstica)
 * y delega al repositorio y mapper correspondiente.
 * 
 * @author Dragonico
 */
@Service
public class OrderAdapter implements OrderPort {

    @Autowired private MedicationOrderRepository medicationRepo;
    @Autowired private ProcedureOrderRepository procedureRepo;
    @Autowired private DiagnosticAidOrderRepository diagnosticRepo;

    // ---------------------- REGISTER ----------------------
    @Override
    public void registerOrder(Order order) throws Exception {
        if (order == null) throw new Exception("La orden médica no puede ser nula.");

        if (order instanceof MedicationOrder medication) {
            medicationRepo.save(MedicationOrderMapper.toEntity(medication));

        } else if (order instanceof ProcedureOrder procedure) {
            procedureRepo.save(ProcedureOrderMapper.toEntity(procedure));

        } else if (order instanceof DiagnosticAidOrder diagnostic) {
            diagnosticRepo.save(DiagnosticAidOrderMapper.toEntity(diagnostic));

        } else {
            throw new Exception("Tipo de orden desconocido: " + order.getClass().getSimpleName());
        }
    }

    // ---------------------- UPDATE ----------------------
    @Override
    public void updateOrder(String orderId, Order updatedData) throws Exception {
        if (updatedData == null) throw new Exception("Los datos actualizados no pueden ser nulos.");

        Long id = parseId(orderId);

        if (updatedData instanceof MedicationOrder medication) {
            MedicationOrderEntity existing = medicationRepo.findById(id)
                    .orElseThrow(() -> new Exception("No se encontró la orden de medicamento con ID: " + orderId));
            MedicationOrderEntity updated = MedicationOrderMapper.toEntity(medication);
            updated.setId(existing.getId());
            medicationRepo.save(updated);

        } else if (updatedData instanceof ProcedureOrder procedure) {
            ProcedureOrderEntity existing = procedureRepo.findById(id)
                    .orElseThrow(() -> new Exception("No se encontró la orden de procedimiento con ID: " + orderId));
            ProcedureOrderEntity updated = ProcedureOrderMapper.toEntity(procedure);
            updated.setId(existing.getId());
            procedureRepo.save(updated);

        } else if (updatedData instanceof DiagnosticAidOrder diagnostic) {
            DiagnosticAidOrderEntity existing = diagnosticRepo.findById(id)
                    .orElseThrow(() -> new Exception("No se encontró la orden diagnóstica con ID: " + orderId));
            DiagnosticAidOrderEntity updated = DiagnosticAidOrderMapper.toEntity(diagnostic);
            updated.setId(existing.getId());
            diagnosticRepo.save(updated);

        } else {
            throw new Exception("Tipo de orden desconocido en actualización.");
        }
    }

    // ---------------------- REMOVE ----------------------
    @Override
    public void removeOrder(String orderId) throws Exception {
        Long id = parseId(orderId);
        boolean deleted = false;

        if (medicationRepo.existsById(id)) {
            medicationRepo.deleteById(id);
            deleted = true;
        } else if (procedureRepo.existsById(id)) {
            procedureRepo.deleteById(id);
            deleted = true;
        } else if (diagnosticRepo.existsById(id)) {
            diagnosticRepo.deleteById(id);
            deleted = true;
        }

        if (!deleted) throw new Exception("No se encontró ninguna orden con ID: " + orderId);
    }

    // ---------------------- SEARCH ----------------------
    @Override
    public Order searchOrderById(String orderId) throws Exception {
        Long id = parseId(orderId);

        if (medicationRepo.existsById(id)) {
            return MedicationOrderMapper.toDomain(medicationRepo.findById(id).orElse(null));
        } else if (procedureRepo.existsById(id)) {
            return ProcedureOrderMapper.toDomain(procedureRepo.findById(id).orElse(null));
        } else if (diagnosticRepo.existsById(id)) {
            return DiagnosticAidOrderMapper.toDomain(diagnosticRepo.findById(id).orElse(null));
        }

        throw new Exception("No se encontró ninguna orden con ID: " + orderId);
    }

    // ---------------------- LIST BY PATIENT ----------------------
    @Override
    public List<Order> listOrdersByPatient(String patientId) throws Exception {
        var meds = medicationRepo.findByPatientId(patientId).stream()
                .map(MedicationOrderMapper::toDomain).collect(Collectors.toList());
        var procs = procedureRepo.findByPatientId(patientId).stream()
                .map(ProcedureOrderMapper::toDomain).collect(Collectors.toList());
        var diags = diagnosticRepo.findByPatientId(patientId).stream()
                .map(DiagnosticAidOrderMapper::toDomain).collect(Collectors.toList());

        List<Order> allOrders = new java.util.ArrayList<>();
        allOrders.addAll(meds);
        allOrders.addAll(procs);
        allOrders.addAll(diags);
        return allOrders;

    }

    // ---------------------- UTILS ----------------------
    private Long parseId(String id) throws Exception {
        try {
            return Long.valueOf(id);
        } catch (NumberFormatException e) {
            throw new Exception("El ID de la orden debe ser un número válido (Long).");
        }
    }
    
    
}
