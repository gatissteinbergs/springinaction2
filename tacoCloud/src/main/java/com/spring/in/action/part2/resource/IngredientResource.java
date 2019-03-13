package com.spring.in.action.part2.resource;

import com.spring.in.action.part2.model.Ingredient;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;

public class IngredientResource extends ResourceSupport {

    @Getter
    private String name;

    @Getter
    private Ingredient.Type type;

    public IngredientResource(Ingredient ingredient) {
        this.name = ingredient.getName();
        this.type = ingredient.getType();
    }

}