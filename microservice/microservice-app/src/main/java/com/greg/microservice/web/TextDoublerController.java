package com.greg.microservice.web;

import com.greg.microsservice.shared.client.TextDoublerClient;
import com.greg.microsservice.shared.model.TextDoubleRequest;
import com.greg.microsservice.shared.model.TextDoubleResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/home")
@Slf4j
public class TextDoublerController implements TextDoublerClient {
    @PostMapping("text-double")
    public TextDoubleResult hello(@Valid @RequestBody TextDoubleRequest textDoubleRequest) {
        log.info("Message recieved "+ textDoubleRequest.text());
        return new TextDoubleResult(textDoubleRequest.text() + textDoubleRequest.text());
    }

    @GetMapping("test-error")
    public void testError() {
        var customer = new Customer("Bob",new Address(new Country(null)));
        log.info(customer.address().country().timeZone().zone());
    }

    @GetMapping("delay")
    public void delay(@RequestParam("milliseconds") int milliseconds)  {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw  new RuntimeException(e);
        }
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

