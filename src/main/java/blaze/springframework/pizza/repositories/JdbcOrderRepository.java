package blaze.springframework.pizza.repositories;

import blaze.springframework.pizza.domain.Order;
import blaze.springframework.pizza.domain.Pizza;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JdbcOrderRepository implements OrderRepository {
    private SimpleJdbcInsert orderInserter;
    private SimpleJdbcInsert orderTacoInserter;
    private ObjectMapper objectMapper;

    @Autowired
    public JdbcOrderRepository(JdbcTemplate jdbc) {
        this.orderInserter = new SimpleJdbcInsert(jdbc)
                .withTableName("Pizza_Order")
                .usingGeneratedKeyColumns("id");

        this.orderTacoInserter = new SimpleJdbcInsert(jdbc)
                .withTableName("Pizza_order_Pizzas");

        this.objectMapper = new ObjectMapper();
    }

    @Override
    public Order save(Order order) {
        order.setPlacedAt(new Date());
        long orderId = saveOrderDetails(order);
        order.setId(orderId);
        List<Pizza> pizzas = order.getPizzas();
        for (Pizza pizza : pizzas) {
            savePizzaToOrder(pizza, orderId);
        }
        return order;
    }

    private long saveOrderDetails(Order order) {
        @SuppressWarnings("unchecked")
        Map<String, Object> values =
                objectMapper.convertValue(order, Map.class);
        values.put("placedAt", order.getPlacedAt());

        long orderId =
                orderInserter
                        .executeAndReturnKey(values)
                        .longValue();
        return orderId;
    }

    private void savePizzaToOrder(Pizza pizza, long orderId) {
        Map<String, Object> values = new HashMap<>();
        values.put("pizzaOrder", orderId);
        values.put("pizza", pizza.getId());
        orderTacoInserter.execute(values);
    }
}