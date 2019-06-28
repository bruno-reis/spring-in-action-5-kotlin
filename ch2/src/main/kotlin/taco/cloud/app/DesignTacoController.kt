package taco.cloud.app

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.util.Arrays.asList


@Controller
@RequestMapping("/design")
class DesignTacoController : Logging{

    @GetMapping
    fun showDesignForm(model: Model): String {
        val ingredients = asList(
            Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP),
            Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP),
            Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN),
            Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN),
            Ingredient("TMTO", "Diced Tomato", Ingredient.Type.VEGGIES),
            Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES),
            Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
            Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE),
            Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE),
            Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE)
        )

        ingredients
            .groupBy { it.type}
            .map { model.addAttribute(it.key.toString().toLowerCase(), it.value) }

        model.addAttribute("design", Taco())

        return "design"
    }

    @PostMapping
    fun processDesign(taco: Taco): String {
        logger().info("Taco Design: $taco")

        return "redirect:/orders/current"
    }
}
