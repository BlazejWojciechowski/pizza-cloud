package blaze.springframework.pizza.repositories;

import blaze.springframework.pizza.domain.Order;

public interface OrderRepository {
    Order save(Order order);
}