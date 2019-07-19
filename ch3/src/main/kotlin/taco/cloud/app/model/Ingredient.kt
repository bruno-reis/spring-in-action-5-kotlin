package taco.cloud.app.model

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Ingredient(
    @Id val id: String,
    val name: String,
    val type: Ingredient.Type
) {
    enum class Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
