package taco.cloud.app.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import taco.cloud.app.Logging
import taco.cloud.app.logger
import taco.cloud.app.model.Order
import javax.validation.Valid

@Controller
@RequestMapping("/orders")
class OrderController : Logging {

    @GetMapping("/current")
    fun orderForm(model: Model): String {
        model.addAttribute("order", Order())
        return "orderForm"
    }

    @PostMapping
    fun processOrder(@Valid order: Order, errors: Errors): String {
        logger().info("Order Submitted $order")

        if (errors.hasErrors()) return "orderForm"

        return "redirect:/"
    }
}
