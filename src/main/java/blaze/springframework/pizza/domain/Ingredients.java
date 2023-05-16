package blaze.springframework.pizza.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Ingredients {
    private final  String id;
    private final String name;
    private final Type type;

    public enum Type {
        DOUGH, PROTEIN, CHEESE, VEGGIES, SALAD, SAUCE
    }
}