package com.greg.microsrevice.reactive;

import com.greg.microsservice.shared.TextDoubleRequest;
import com.greg.microsservice.shared.TextDoubleResult;
import com.greg.microsservice.shared.TextDoublerReactiveClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/home")

public class HomeController {
    @Autowired
    TextDoublerReactiveClient textDoublerReactiveClient;

    @GetMapping("text-double")
    Mono<TextDoubleResult> test(){
        return textDoublerReactiveClient.hello(new TextDoubleRequest("hello from Feign")).map(s -> s);
    }

    @GetMapping("test-error")
    Mono testError(){
        return textDoublerReactiveClient.testError();
    }
}
