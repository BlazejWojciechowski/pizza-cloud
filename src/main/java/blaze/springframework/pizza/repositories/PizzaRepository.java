package blaze.springframework.pizza.repositories;

import blaze.springframework.pizza.domain.Pizza;

public interface PizzaRepository  {
    Pizza save(Pizza design);
}