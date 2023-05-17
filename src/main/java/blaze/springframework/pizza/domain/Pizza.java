package blaze.springframework.pizza.domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;
@Data
public class Pizza {
    @NotNull
    @Size(min=5, message="Nazwa musi składać się z przynajmniej pięciu znaków")
    private String name;
    @NotNull
    @Size(min=1, message="Musisz wybrać przynajmniej jeden składnik")
    private List<String> ingredients;
}
