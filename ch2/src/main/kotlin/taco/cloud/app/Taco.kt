package taco.cloud.app

import org.jetbrains.annotations.NotNull
import javax.validation.constraints.Size

data class Taco(
    @field:NotNull
    @field:Size(min=5, message = "Name must be at least 5 character long")
    val name: String? = null,

    @field:Size(min=1, message = "Choose at least one Ingredient")
    val ingredients: List<String>? = null
)
