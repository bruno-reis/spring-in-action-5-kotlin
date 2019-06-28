package taco.cloud.app

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/orders")
class OrderController: Logging {

    @GetMapping("/current")
    fun orderForm(model: Model) : String {
        model.addAttribute("order", Order())
        return "orderForm"
    }

    @PostMapping
    fun processOrder(order: Order): String {
        logger().info("Order Submitted $order")
        return "redirect:/"
    }
}
