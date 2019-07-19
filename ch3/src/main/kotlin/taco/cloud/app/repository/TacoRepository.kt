package taco.cloud.app.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Component
import taco.cloud.app.model.Taco

@Component
interface TacoRepository : CrudRepository<Taco, Long>
