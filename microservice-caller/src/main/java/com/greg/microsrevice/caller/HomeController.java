package com.greg.microsrevice.caller;

import com.greg.microsservice.shared.HelloClient;
import com.greg.microsservice.shared.HelloModel;
import com.greg.microsservice.shared.HelloRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    HelloClient helloClient;

    @GetMapping
    HelloModel test(){
        return helloClient.hello(new HelloRequest("hello from Feign"));
    }

    @GetMapping("error")
    void testError(){
         helloClient.testError();
    }
}
