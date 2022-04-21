package com.greg.microsrevice.caller.reactive;

import lombok.extern.slf4j.Slf4j;
import reactivefeign.client.ReactiveHttpRequest;
import reactivefeign.client.ReactiveHttpRequestInterceptor;
import reactor.core.publisher.Mono;

@Slf4j
public class RequestLoggerInterceptor implements ReactiveHttpRequestInterceptor {

    static int count;

    @Override
    public Mono<ReactiveHttpRequest> apply(ReactiveHttpRequest reactiveHttpRequest) {
        count++;
        log.info("Calling microservice - call number " + count);
        return Mono.just(reactiveHttpRequest);
    }
}