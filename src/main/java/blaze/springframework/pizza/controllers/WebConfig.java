package blaze.springframework.pizza.controllers;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/history").setViewName("history");
        registry.addViewController("/menu").setViewName("menu");
        registry.addViewController("/address").setViewName("address");
        registry.addViewController("/us").setViewName("us");
        registry.addViewController("/order").setViewName("orderForm");
    }
}
