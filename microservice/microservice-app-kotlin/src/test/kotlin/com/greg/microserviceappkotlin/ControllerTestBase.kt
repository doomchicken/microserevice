package com.greg.microserviceappkotlin

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.test.web.servlet.MockMvc
import java.lang.RuntimeException
import kotlin.Throws
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import com.greg.microsservice.shared.model.CustomerCreateRequest
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.MvcResult
import com.greg.microsservice.shared.model.CustomerModel
import org.hamcrest.MatcherAssert
import com.greg.microsservice.shared.model.TextDoubleRequest
import com.greg.microsservice.shared.model.TextDoubleResult
import org.springframework.beans.factory.annotation.Autowired

@SpringBootTest
@AutoConfigureMockMvc
open class ControllerTestBase (@Autowired  protected val mockMvc: MockMvc){
    protected fun asJsonString(obj: Any?): String {
        return try {
            ObjectMapper().writeValueAsString(obj)
        } catch (e: JsonProcessingException) {
            throw RuntimeException(e)
        }
    }

    protected fun <T> asJsonObject(jsonString: String?, valueType: Class<T>?): T? {
        return if (jsonString == null || jsonString.isBlank()) {
            null
        } else try {
            val mapper = ObjectMapper()
            mapper.findAndRegisterModules()
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            mapper.readValue(jsonString, valueType)
        } catch (e: JsonProcessingException) {
            throw RuntimeException(e)
        }
    }

    protected fun <T> asJsonObject(jsonString: String?, valueType: TypeReference<T>?): T? {
        return if (jsonString == null || jsonString.isBlank()) {
            null
        } else try {
            val mapper = ObjectMapper()
            mapper.findAndRegisterModules()
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            mapper.readValue(jsonString, valueType)
        } catch (e: JsonProcessingException) {
            throw RuntimeException(e)
        }
    }
}