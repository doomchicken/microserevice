package com.greg.microsservice.shared;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "hello" , url = "${hello.url}" , path = "home")
public interface HelloClient {
    @PostMapping
    HelloModel hello(HelloRequest request);

    @GetMapping("test-error")
    void testError();
}