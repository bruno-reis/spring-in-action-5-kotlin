package taco.cloud.app

import java.util.Arrays.asList

data class Taco(
    val name: String = "Taco",
    val ingredients: List<String> = asList("")
)
