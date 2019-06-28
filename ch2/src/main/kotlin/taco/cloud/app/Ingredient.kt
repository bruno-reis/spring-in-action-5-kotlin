package taco.cloud.app

data class Ingredient(val id: String, val name: String, val type: Type) {

    enum class Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
