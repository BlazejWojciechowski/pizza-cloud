package blaze.springframework.pizza.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@NoArgsConstructor(access= AccessLevel.PUBLIC, force=true)
@Data
@Entity
public class Ingredient {
    @Id
    private final String id;
    private final String name;
    private final Type type;

    public enum Type {
        DOUGH, PROTEIN, VEGGIES, CHEESE, SALAD, SAUCE
    }
}