package blaze.springframework.pizza.repositories;

import blaze.springframework.pizza.domain.Pizza;
import org.springframework.data.repository.CrudRepository;

public interface PizzaRepository
        extends CrudRepository<Pizza, Long> {

}
