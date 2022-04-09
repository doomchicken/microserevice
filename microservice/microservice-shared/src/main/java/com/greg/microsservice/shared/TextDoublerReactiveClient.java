package com.greg.microsservice.shared;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

@ReactiveFeignClient(value = "textdoubler-reactive" , url = "${textdoubler.url}" , path = "home")
public interface TextDoublerReactiveClient {
    @PostMapping("text-double")
    Mono<TextDoubleResult> hello(TextDoubleRequest request);

    @GetMapping("test-error")
    Mono<String> testError();
}