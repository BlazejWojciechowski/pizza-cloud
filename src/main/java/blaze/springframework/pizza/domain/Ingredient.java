package blaze.springframework.pizza.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Ingredient {
    private final  String id;
    private final String name;
    private final Type type;

    public enum Type {
        DOUGH, PROTEIN, VEGGIES, CHEESE, SALAD, SAUCE
    }
}