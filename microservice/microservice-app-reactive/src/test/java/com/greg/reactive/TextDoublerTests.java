package com.greg.reactive;

import com.greg.microsservice.shared.model.TextDoubleRequest;
import com.greg.microsservice.shared.model.TextDoubleResult;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import reactor.core.publisher.Mono;

public class TextDoublerTests extends ControllerTestBase {

    @Test
    public void shouldDoubleText() {
        webTestClient.post().uri("/home/text-double")
                        .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(new TextDoubleRequest("hello")),TextDoubleRequest.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .json(asJsonString(new TextDoubleResult("hellohello")));
    }

//    @Test
//    public void shouldFailDoubleText_InvalidRequesst() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.post("/home/text-double")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(asJsonString(new TextDoubleRequest(null))))
//                .andExpect(status().is4xxClientError());
//    }
//
//    @Test
//    public void shouldErrorTestError() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.post("/home/test-error")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(asJsonString(new TextDoubleRequest(null))))
//                .andExpect(status().is4xxClientError());
//    }
//
//
//    @Test
//    public void shouldDelay() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/home/delay")
//                        .param("milliseconds","200"))
//                .andExpect(status().isOk());
//    }
}
