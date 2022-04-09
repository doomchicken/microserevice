//package com.greg.microsrevice.caller;
//
//import feign.RequestInterceptor;
//import feign.RequestTemplate;
//import lombok.extern.slf4j.Slf4j;
//import reactivefeign.client.ReactiveHttpRequest;
//import reactivefeign.client.ReactiveHttpRequestInterceptor;
//import reactor.core.publisher.Mono;
//
//import java.nio.charset.StandardCharsets;
//
//@Slf4j
//public class RequestLoggerInterceptor implements ReactiveHttpRequestInterceptor {
//
//    static int count;
//
//    @Override
//    public void apply(RequestTemplate requestTemplate) {
//
//    }
//
//    @Override
//    public Mono<ReactiveHttpRequest> apply(ReactiveHttpRequest reactiveHttpRequest) {
//        count++;
//        log.info("Calling microservice - call number " + count);
//        reactiveHttpRequest.body().subscribe(i->
//                log.info(new String(i , StandardCharsets.UTF_8));
//    }}
//}