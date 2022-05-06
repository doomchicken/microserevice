package com.greg.microserviceappkotlin

import com.greg.microsservice.shared.model.TextDoubleRequest
import com.greg.microsservice.shared.model.TextDoubleResult
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

class TextDoublerTests : ControllerTestBase() {
    @Test
    @Throws(Exception::class)
    fun shouldDoubleText() {
        mockMvc!!.perform(
            MockMvcRequestBuilders.post("/home/text-double")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(TextDoubleRequest("hello")))
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(
                MockMvcResultMatchers.content().json(
                    asJsonString(TextDoubleResult("hellohello"))
                )
            )
    }

    @Test
    @Throws(Exception::class)
    fun shouldFailDoubleText_InvalidRequesst() {
        mockMvc!!.perform(
            MockMvcRequestBuilders.post("/home/text-double")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(TextDoubleRequest(null)))
        )
            .andExpect(MockMvcResultMatchers.status().is4xxClientError)
    }

    @Test
    @Throws(Exception::class)
    fun shouldErrorTestError() {
        mockMvc!!.perform(
            MockMvcRequestBuilders.post("/home/test-error")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(TextDoubleRequest(null)))
        )
            .andExpect(MockMvcResultMatchers.status().is4xxClientError)
    }

    @Test
    @Throws(Exception::class)
    fun shouldDelay() {
        mockMvc!!.perform(
            MockMvcRequestBuilders.get("/home/delay")
                .param("milliseconds", "200")
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
    }
}