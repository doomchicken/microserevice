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

    @Test
    public void shouldFailDoubleText_InvalidRequesst() throws Exception {
        webTestClient.post().uri("/home/text-double")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(new TextDoubleRequest(null)),TextDoubleRequest.class)
                .exchange()
                .expectStatus().is4xxClientError();
    }

    @Test
    public void shouldErrorTestError() throws Exception {
        webTestClient.get().uri("/home/test-error")
                .exchange()
                .expectStatus().is5xxServerError();
    }


    @Test
    public void shouldDelay() throws Exception {
        webTestClient.get().uri(uriBuilder -> uriBuilder
                .path("/home/delay/")
                .queryParam("milliseconds", "200")
                .build())
                .exchange()
                .expectStatus().isOk();
    }
}
