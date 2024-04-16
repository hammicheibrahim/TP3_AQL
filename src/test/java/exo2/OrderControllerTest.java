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
        // Création d'un mock pour OrderDao
        OrderDao mockOrderDao = mock(OrderDao.class);

        // Création d'un mock pour OrderService
        OrderService mockOrderService = mock(OrderService.class);

        // Création d'un objet OrderController en lui passant le mockOrderService
        OrderController orderController = new OrderController(mockOrderService);

        // Création d'une commande fictive pour les tests
        Order order = new Order(/* order details */);

        // Appel de la méthode createOrder de OrderController avec la commande fictive
        orderController.createOrder(order);

        // Vérification que la méthode createOrder de OrderService a bien été appelée avec la commande en argument
        verify(mockOrderService).createOrder(order);

        OrderService orderService = new OrderService(mockOrderDao);
        orderService.createOrder(order);
        verify(mockOrderDao).saveOrder(order);

    }
}
