package com.greg.microsrevice.caller;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import reactivefeign.client.ReactiveHttpRequest;
import reactivefeign.client.ReactiveHttpRequestInterceptor;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

@Slf4j
public class RequestLoggerInterceptor implements RequestInterceptor {

    static int count;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        count++;
        log.info("Calling microservice - call number " + count);
        if (requestTemplate.body() !=null) {
            log.info(new String(requestTemplate.body(), StandardCharsets.UTF_8));
        }
    }
}