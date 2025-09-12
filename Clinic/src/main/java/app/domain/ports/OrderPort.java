package app.domain.ports;

import app.domain.model.Order;
import java.util.List;

public interface OrderPort{

    void registerOrder(Order order) throws Exception;

    void updateOrder(String orderId, Order updatedData) throws Exception;

    void removeOrder(String orderId) throws Exception;

    Order searchOrderById(String orderId) throws Exception;

    List<Order> listOrdersByPatient(String patientId) throws Exception;
}
