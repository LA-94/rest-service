package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String TEMPLATE = "Hello, %s!";
    public static final AtomicLong COUNTER = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(name = "name", defaultValue = "World") String name) {
        long id = COUNTER.incrementAndGet();
        String content = String.format(TEMPLATE, name);

        return new Greeting(id, content);
    }
}
