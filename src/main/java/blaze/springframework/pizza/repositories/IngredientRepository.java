package blaze.springframework.pizza.repositories;

import blaze.springframework.pizza.domain.Ingredient;

public interface IngredientRepository {
<<<<<<< HEAD

    Iterable<Ingredient> findAll();

    Ingredient findById(String id);

    Ingredient save(Ingredient ingredient);

}

=======
    Iterable<Ingredient> findAll();
    Ingredient findById(String id);
    Ingredient save(Ingredient ingredient);
}
>>>>>>> origin/jdbc
