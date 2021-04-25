package ru.ahmetoff.javaspringhelloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
@RestController
public class JavaSpringHelloWorldApplication {
    private final AtomicLong counter = new AtomicLong();

    public static void main(String[] args) {
        SpringApplication.run(JavaSpringHelloWorldApplication.class, args);
    }

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "world") String name) {
        return new Greeting(counter.incrementAndGet(), "Hello, " + name + "!");
    }
}
