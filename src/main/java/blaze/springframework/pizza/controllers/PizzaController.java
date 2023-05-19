package blaze.springframework.pizza.controllers;

import blaze.springframework.pizza.domain.Ingredient;
import blaze.springframework.pizza.domain.Ingredient.Type;
import blaze.springframework.pizza.domain.Order;
import blaze.springframework.pizza.domain.Pizza;
import blaze.springframework.pizza.repositories.IngredientRepository;
import blaze.springframework.pizza.repositories.PizzaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class PizzaController {

    private final IngredientRepository ingredientRepo;

    private PizzaRepository pizzaRepo;

    @Autowired
    public PizzaController(IngredientRepository ingredientRepo, PizzaRepository pizzaRepo) {
        this.ingredientRepo = ingredientRepo;
        this.pizzaRepo = pizzaRepo;
    }

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "design")
    public Pizza design() {
        return new Pizza();
    }

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("THIN", "cienkie", Type.DOUGH),
                new Ingredient("FATT", "grube", Type.DOUGH),
                new Ingredient("SALA", "salami", Type.PROTEIN),
                new Ingredient("PROS", "prosciutto", Type.PROTEIN),
                new Ingredient("TMTO", "pomidory", Type.VEGGIES),
                new Ingredient("PICK", "korniszony", Type.VEGGIES),
                new Ingredient("CHED", "cheddar", Type.CHEESE),
                new Ingredient("MOZZ", "mozzarella", Type.CHEESE),
                new Ingredient("AGRU", "rukola", Type.SALAD),
                new Ingredient("BASI", "bazylia", Type.SALAD),
                new Ingredient("SLSA", "salsa", Type.SAUCE),
                new Ingredient("STMT", "pomidorowy", Type.SAUCE)
        );
        ingredientRepo.saveAll(ingredients);

        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
        return "design";
    }

    @PostMapping
    public String processDesign(
            @Valid @ModelAttribute("design") Pizza design, Errors errors,
            @ModelAttribute Order order, Model model) {

        if (errors.hasErrors()) {
            return "design";
        }

        Pizza saved = pizzaRepo.save(design);
        order.addDesign(saved);

        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType(
            List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}