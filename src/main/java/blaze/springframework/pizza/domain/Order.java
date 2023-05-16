package blaze.springframework.pizza.domain;

import lombok.Data;

@Data
public class Order {
    private String id;
    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;
}
