package com.ironhack.hellocrud.model;

import lombok.Data;

@Data
public class UpdateCoffeeNameRequest {
    private Long coffeeId;
    private String name;
}
