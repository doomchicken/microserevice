package com.greg.microsservice.shared.client;

import com.greg.microsservice.shared.model.TextDoubleRequest;
import com.greg.microsservice.shared.model.TextDoubleResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "textdoubler" , url = "${textdoubler.url}" , path = "home")
public interface TextDoublerClient {
    @PostMapping("text-double")
    TextDoubleResult hello(TextDoubleRequest request);

    @GetMapping("test-error")
    void testError();

    @GetMapping("delay")
    void delay(@RequestParam("milliseconds") int milliseconds);
}