package com.spring.in.action.part2.repository;

import com.spring.in.action.part2.model.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@Repository
@RepositoryRestResource
public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}