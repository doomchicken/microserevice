package com.greg.microserviceappkotlin

import com.greg.microsservice.shared.model.CustomerCreateRequest
import com.greg.microsservice.shared.model.CustomerModel
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

class CustomerTests (@Autowired  mockMvc: MockMvc): ControllerTestBase (mockMvc){
    @Test
    @Throws(Exception::class)
    fun shouldCreateCustomer() {
        mockMvc.perform(
            MockMvcRequestBuilders.post("/customer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(CustomerCreateRequest("Bob")))
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
    }

    @Test
    @Throws(Exception::class)
    fun shouldGetAllCustomers() {
        val getCustomersInitial = mockMvc.perform(
            MockMvcRequestBuilders.get("/customer")
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andReturn()
        val customersInitial =
            asJsonObject(getCustomersInitial.response.contentAsString, Array<CustomerModel>::class.java)
        MatcherAssert.assertThat(customersInitial!!.size, Matchers.`is`(0))
        mockMvc.perform(
            MockMvcRequestBuilders.post("/customer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(CustomerCreateRequest("Bob")))
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
        mockMvc.perform(
            MockMvcRequestBuilders.post("/customer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(CustomerCreateRequest("Bob")))
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
        val getCustomersFinal = mockMvc.perform(
            MockMvcRequestBuilders.get("/customer")
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andReturn()
        val customersFinal =
            asJsonObject(getCustomersFinal.response.contentAsString, Array<CustomerModel>::class.java)
        MatcherAssert.assertThat(customersFinal!!.size, Matchers.`is`(2))
    }
}