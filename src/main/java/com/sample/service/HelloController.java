package com.sample.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HelloController {

    @GetMapping(path="/test", produces = "application/json")
    public Mono<String> display() {
        return Mono.just("Hi Anil!!");
    }

    @GetMapping(path="/test1", produces = "application/html")
    public String display1() {
        return "Hi Anil!!";
    }
}
