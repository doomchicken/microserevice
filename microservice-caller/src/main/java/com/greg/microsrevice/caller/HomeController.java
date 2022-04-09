package com.greg.microsrevice.caller;

import com.greg.microsservice.shared.TextDoublerClient;
import com.greg.microsservice.shared.TextDoubleResult;
import com.greg.microsservice.shared.TextDoubleRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    TextDoublerClient textDoublerClient;

    @GetMapping("text-double")
    TextDoubleResult test(){
        return textDoublerClient.hello(new TextDoubleRequest("hello from Feign"));
    }

    @GetMapping("test-error")
    void testError(){
         textDoublerClient.testError();
    }
}
