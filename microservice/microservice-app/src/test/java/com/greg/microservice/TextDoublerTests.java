package com.greg.microservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greg.microsservice.shared.model.TextDoubleRequest;
import com.greg.microsservice.shared.model.TextDoubleResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class TextDoublerTests extends ControllerTestBase {

    @Test
    public void shouldDoubleText() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/home/text-double")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(new TextDoubleRequest("hello"))))
                .andExpect(status().isOk())
                .andExpect(content().json(asJsonString(new TextDoubleResult("hellohello"))
                ));
    }

    @Test
    public void shouldFailDoubleText_InvalidRequesst() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/home/text-double")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(new TextDoubleRequest(null))))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void shouldErrorTestError() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/home/test-error")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(new TextDoubleRequest(null))))
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void shouldDelay() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/home/delay")
                        .param("milliseconds","200"))
                .andExpect(status().isOk());
    }
}
