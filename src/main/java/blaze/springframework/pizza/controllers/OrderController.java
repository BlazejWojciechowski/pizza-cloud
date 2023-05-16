package blaze.springframework.pizza.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class OrderController {
    @GetMapping("/order")
    public String orderForm() {
        return "orderForm";
    }
}
