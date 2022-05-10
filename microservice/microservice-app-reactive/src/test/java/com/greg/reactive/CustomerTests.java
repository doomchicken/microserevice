package com.greg.reactive;

import com.greg.microsservice.shared.model.CustomerCreateRequest;
import com.greg.microsservice.shared.model.CustomerModel;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import reactor.core.publisher.Mono;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CustomerTests extends ControllerTestBase{
    @Test
    public void shouldCreateCustomer() throws Exception {
        webTestClient.post().uri("/customer")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(new CustomerCreateRequest("bob")),CustomerCreateRequest.class)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void shouldGetAllCustomers() throws Exception {
        var result = webTestClient.get().uri("/customer")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .returnResult();

        var customersInitial = asJsonObject(new String(result.getResponseBody()), CustomerModel[].class);

        assertThat(customersInitial.length, equalTo(0));

        webTestClient.post().uri("/customer")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(new CustomerCreateRequest("bob")),CustomerCreateRequest.class)
                .exchange()
                .expectStatus().isOk();

        webTestClient.post().uri("/customer")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(new CustomerCreateRequest("bob2")),CustomerCreateRequest.class)
                .exchange()
                .expectStatus().isOk();

        var finalResult = webTestClient.get().uri("/customer")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .returnResult();

        var customersFinal = asJsonObject(new String(finalResult.getResponseBody()), CustomerModel[].class);

        assertThat(customersFinal.length, equalTo(2));
    }
}
