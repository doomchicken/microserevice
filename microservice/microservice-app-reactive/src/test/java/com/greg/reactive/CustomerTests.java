//package com.greg.reactive;
//
//import com.greg.microsservice.shared.model.CustomerCreateRequest;
//import com.greg.microsservice.shared.model.CustomerModel;
//import org.junit.jupiter.api.Test;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.is;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//public class CustomerTests extends ControllerTestBase{
//    @Test
//    public void shouldCreateCustomer() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.post("/customer")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(asJsonString(new CustomerCreateRequest("Bob"))))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    public void shouldGetAllCustomers() throws Exception {
//        MvcResult getCustomersInitial = mockMvc.perform(MockMvcRequestBuilders.get("/customer")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andReturn();
//
//        CustomerModel[] customersInitial = asJsonObject(getCustomersInitial.getResponse().getContentAsString(), CustomerModel[].class);
//        assertThat(customersInitial.length, is(0));
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/customer")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(asJsonString(new CustomerCreateRequest("Bob"))))
//                .andExpect(status().isOk());
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/customer")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(asJsonString(new CustomerCreateRequest("Bob"))))
//                .andExpect(status().isOk());
//
//        MvcResult getCustomersFinal = mockMvc.perform(MockMvcRequestBuilders.get("/customer")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andReturn();
//
//        CustomerModel[] customersFinal = asJsonObject(getCustomersFinal.getResponse().getContentAsString(), CustomerModel[].class);
//        assertThat(customersFinal.length, is(2));
//    }
//}
