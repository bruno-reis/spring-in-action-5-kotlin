package taco.cloud.app.model

import org.jetbrains.annotations.NotNull
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.PrePersist
import javax.validation.constraints.Size

@Entity
data class Taco(

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,

    @field:NotNull
    @field:Size(min = 5, message = "Name must be at least 5 character long")
    val name: String? = null,

    @ManyToMany(targetEntity = Ingredient::class)
    @field:Size(min = 1, message = "Choose at least one Ingredient")
    val ingredients: List<String>? = null,

    var createdAt: LocalDate? = null
) {
    @PrePersist
    fun createdAt() {
        createdAt = LocalDate.now()
    }
}
