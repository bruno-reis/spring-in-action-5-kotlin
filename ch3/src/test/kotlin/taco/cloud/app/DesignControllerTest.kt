package taco.cloud.app

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import taco.cloud.app.controller.DesignTacoController

@RunWith(SpringRunner::class)
@WebMvcTest(DesignTacoController::class)
class DesignControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    @Throws(Exception::class)
    fun testDesignPage() {
        mockMvc.perform(get("/design"))
            .andExpect(status().isOk)
            .andExpect(MockMvcResultMatchers.view().name("design"))
    }
}
