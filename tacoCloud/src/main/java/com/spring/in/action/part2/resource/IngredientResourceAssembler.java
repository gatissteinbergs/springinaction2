package com.spring.in.action.part2.resource;

import com.spring.in.action.part2.controller.IngredientController;
import com.spring.in.action.part2.model.Ingredient;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

class IngredientResourceAssembler extends
        ResourceAssemblerSupport<Ingredient, IngredientResource> {

    public IngredientResourceAssembler() {
        super(IngredientController.class, IngredientResource.class);
    }

    @Override
    public IngredientResource toResource(Ingredient ingredient) {
        return createResourceWithId(ingredient.getId(), ingredient);
    }

    @Override
    protected IngredientResource instantiateResource(Ingredient ingredient) {
        return new IngredientResource(ingredient);
    }

}