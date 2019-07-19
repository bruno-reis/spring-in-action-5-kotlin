package taco.cloud.app.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import taco.cloud.app.model.Ingredient

@Repository
interface IngredientRepository : CrudRepository<Ingredient, String>
