package taco.cloud.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
class AppApplication

fun main(args: Array<String>) {
    runApplication<AppApplication>(*args)
}
