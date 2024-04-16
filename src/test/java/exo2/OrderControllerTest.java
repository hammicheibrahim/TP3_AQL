package exo2;

import org.example.exo2.Order;
import org.example.exo2.OrderController;
import org.example.exo2.OrderDao;
import org.example.exo2.OrderService;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class OrderControllerTest {

    @Test
    public void testCreateOrder() {
        /////////////////////////////////////////////////////
        OrderService mockOrderService = mock(OrderService.class);
        OrderController orderController = new OrderController(mockOrderService);
        Order order = new Order();
        orderController.createOrder(order);
        verify(mockOrderService).createOrder(order);
        //////////////////////////////////////////////////
        OrderDao mockOrderDao = mock(OrderDao.class);
        OrderService orderService = new OrderService(mockOrderDao);
        orderService.createOrder(order);
        verify(mockOrderDao).saveOrder(order);
    }
}
