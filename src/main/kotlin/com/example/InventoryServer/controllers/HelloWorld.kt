package com.example.InventoryServer.controllers

import org.springframework.web.bind.annotation.*

@RestController
class HelloWorld {
    @RequestMapping("/")
    fun index(@RequestParam name:String):String = "Hello, $name and Welcome"
}