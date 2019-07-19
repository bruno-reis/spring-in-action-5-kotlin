package taco.cloud.app.repository

import org.springframework.data.repository.CrudRepository
import taco.cloud.app.model.Order

interface OrderRepository : CrudRepository<Order, Long> {
    fun findByZip(deliveryZip: String): List<Order>
}
