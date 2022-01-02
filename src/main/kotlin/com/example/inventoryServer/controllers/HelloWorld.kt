package com.example.InventoryServer.controllers

import org.springframework.web.bind.annotation.*

@RestController
class HelloWorld {
    @RequestMapping("/api/greet")
    fun index(@RequestParam name:String):String = "Hello, $name"
}