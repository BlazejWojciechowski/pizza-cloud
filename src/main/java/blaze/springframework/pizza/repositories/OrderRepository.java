package blaze.springframework.pizza.repositories;

import blaze.springframework.pizza.domain.Order;
import org.springframework.data.repository.CrudRepository;


public interface OrderRepository
        extends CrudRepository<Order, Long> {

}