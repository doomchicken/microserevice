package com.greg.microsrevice;

import com.greg.microsservice.shared.HelloClient;
import com.greg.microsservice.shared.HelloModel;
import com.greg.microsservice.shared.HelloRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/home")
@Slf4j
public class HomeController implements HelloClient {
    @PostMapping
    public HelloModel hello(@Valid @RequestBody HelloRequest helloRequest) {
        log.info("Message recieved "+ helloRequest.text());
        return new HelloModel(helloRequest.text());
    }

    @GetMapping("test-error")
    public void testError() {
        var customer = new Customer("Bob",new Address(new Country(null)));
        log.info(customer.address().country().timeZone().zone());
    }

    record Customer(String  name, Address address){

    }

    record Address(Country country){

    }

    record Country(TimeZone timeZone){

    }

    record TimeZone(String zone){

    }
}
