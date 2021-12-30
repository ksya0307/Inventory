package com.example.inventoryServer.controllers
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloWorld {
    @GetMapping("/")
    fun index(): String {
        return "Greetings from Spring Boot!"
    }
    @GetMapping("lisa")
    fun lisa(): String {
        return "Greetings from lisa"
    }
}