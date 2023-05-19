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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class PizzaController {
    private final IngredientRepository ingredientRepo;
    private PizzaRepository pizzaRepository;

    @Autowired
    public PizzaController(IngredientRepository ingredientRepo, PizzaRepository pizzaRepository) {
        this.ingredientRepo = ingredientRepo;
        this.pizzaRepository = pizzaRepository;
    }

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "taco")
    public Pizza taco() {
        return new Pizza();
    }

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepo.findAll().forEach(i -> ingredients.add(i));

        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
        return "design";
    }

    @PostMapping
    public String processDesign(
            @Valid Pizza design, Errors errors,
            @ModelAttribute Order order) {

        if (errors.hasErrors()) {
            return "design";
        }

        Pizza saved = pizzaRepository.save(design);
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