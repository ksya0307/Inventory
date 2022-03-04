package com.example.inventoryServer.controllers

import org.springframework.web.bind.annotation.*

@RestController
class HelloWorld {
    @RequestMapping("/")
    fun index():String = "Hello and Welcome"

}