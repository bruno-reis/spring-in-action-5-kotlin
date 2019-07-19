package taco.cloud.app.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import taco.cloud.app.Logging
import taco.cloud.app.model.Taco
import taco.cloud.app.repository.IngredientRepository
import javax.validation.Valid

@Controller
@RequestMapping("/design")
class DesignTacoController : Logging {

    @Autowired
    lateinit var ingredientRepository: IngredientRepository

    @GetMapping
    fun showDesignForm(model: Model): String {
        val ingredients = ingredientRepository.findAll()

        ingredients
            ?.groupBy { it.type }
            ?.map { model.addAttribute(it.key.toString().toLowerCase(), it.value) }

        model.addAttribute("design", Taco())
        return "design"
    }

    @PostMapping
    fun processDesign(@Valid taco: Taco, errors: Errors): String {
        if (errors.hasErrors()) return "design"

        return "redirect:/orders/current"
    }
}
