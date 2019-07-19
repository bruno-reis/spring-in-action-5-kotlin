package taco.cloud.app.model

import org.hibernate.validator.constraints.CreditCardNumber
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.PrePersist
import javax.persistence.Table
import javax.validation.constraints.Digits
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern

@Entity
@Table(name = "Taco_Order")
data class Order(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,

    var createdAt: LocalDate? = null,

    @ManyToMany(targetEntity = Taco::class)
    var tacos: MutableList<Taco>? = mutableListOf(),

    @field:NotBlank(message = "Name is required")
    val name: String? = null,

    @field:NotBlank(message = "Street is required")
    val street: String? = null,

    @field:NotBlank(message = "City is Required")
    val city: String? = null,

    @field:NotBlank(message = "State is required")
    val state: String? = null,

    @field:NotBlank(message = "Zip code is required")
    val zip: String? = null,

    @field:CreditCardNumber(message = "Not a valid cc number")
    val ccNumber: String? = null,

    @field:Pattern(regexp = "^(0[1-9]|1[0-1])([/])([1-9][0-9])$", message = "Must be a valid MM/YY")
    val ccExpiration: String? = null,

    @field:Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    val ccCVV: String? = null
) {
    @PrePersist
    fun createdAt() {
        createdAt = LocalDate.now()
    }

    fun addDesign(design: Taco) {
        this.tacos?.add(design)
    }
}
