package tp3;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.example.tp3.Order;
import org.example.tp3.OrderController;
import org.example.tp3.OrderDao;
import org.example.tp3.OrderService;
import org.junit.jupiter.api.Test;

class Exo2 {

    @Test
    void testCreateOrder_CallsServiceAndDao() {
        // Arrange
        OrderDao mockOrderDao = mock(OrderDao.class);
        OrderService orderService = new OrderService(mockOrderDao);
        OrderService spyOrderService = spy(orderService); // Spy to verify call
        OrderController orderController = new OrderController(spyOrderService);

        Order testOrder = new Order(1L, "Laptop", 2);

        // Act
        orderController.createOrder(testOrder);

        // Assert
        // 1. Verify that the service's createOrder method was called
        verify(spyOrderService, times(1)).createOrder(testOrder);

        // 2. Verify that the DAO's saveOrder method was called
        verify(mockOrderDao, times(1)).saveOrder(testOrder);
    }
}
