package blaze.springframework.pizza.controllers;

import blaze.springframework.pizza.domain.Ingredient;
import blaze.springframework.pizza.domain.Ingredient.Type;
import blaze.springframework.pizza.domain.Pizza;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
public class PizzaController {
    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("THIN", "na cienkim", Type.DOUGH),
                new Ingredient("FATT", "na grubym", Type.DOUGH),
                new Ingredient("SALA", "salami", Type.PROTEIN),
                new Ingredient("PROS", "prosciutto", Type.PROTEIN),
                new Ingredient("TMTO", "pomidory", Type.VEGGIES),
                new Ingredient("OLIV", "oliwki", Type.VEGGIES),
                new Ingredient("PICK", "ogórek kiszony", Type.VEGGIES),
                new Ingredient("CHED", "cheddar", Type.CHEESE),
                new Ingredient("MOZZ", "mozzarella", Type.CHEESE),
                new Ingredient("ARUG", "rukola", Type.SALAD),
                new Ingredient("BASI", "bazylia", Type.SALAD),
                new Ingredient("SLSA", "pikantny", Type.SAUCE),
                new Ingredient("STMT", "pomidorowy", Type.SAUCE)
        );

        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }

    @GetMapping
    public String showDesignForm(Model model) {
        model.addAttribute("design", new Pizza());
        return "design";
    }

    @PostMapping
    public String processDesign(@Valid @ModelAttribute("design") Pizza design, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "design";
        }

        log.info("Przetwarzanie zamówienia: " + design);

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