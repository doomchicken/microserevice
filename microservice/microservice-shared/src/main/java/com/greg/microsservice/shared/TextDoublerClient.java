package com.greg.microsservice.shared;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "textdoubler" , url = "${textdoubler.url}" , path = "home")
public interface TextDoublerClient {
    @PostMapping("text-doubler")
    TextDoubleResult hello(TextDoubleRequest request);

    @GetMapping("test-error")
    void testError();
}