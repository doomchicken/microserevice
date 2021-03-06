package com.greg.reactive.web;

import com.greg.microsservice.shared.client.TextDoublerReactiveClient;
import com.greg.microsservice.shared.model.TextDoubleRequest;
import com.greg.microsservice.shared.model.TextDoubleResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.time.Duration;

@RestController
@RequestMapping("/home")
@Slf4j
public class TextDoublerController implements TextDoublerReactiveClient {
    @PostMapping("text-double")
    public Mono<TextDoubleResult> hello(@Valid @RequestBody TextDoubleRequest textDoubleRequest) {
        log.info("Message recieved "+ textDoubleRequest.text());
        return Mono.defer(() -> Mono.just( new TextDoubleResult(textDoubleRequest.text() + textDoubleRequest.text()))
                .delaySubscription(Duration.ofMillis(500)));
    }

    @GetMapping("test-error")
    public Mono testError() {
        var customer = new Customer("Bob",new Address(new Country(null)));
        log.info(customer.address().country().timeZone().zone());
        return Mono.just(null);
    }

    @GetMapping("delay")
    public Mono delay(@RequestParam("milliseconds") int milliseconds) {
        return Mono.delay(Duration.ofMillis(milliseconds));
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
