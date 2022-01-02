package com.example.InventoryServer.controllers

import com.example.InventoryServer.entities.User
import com.example.InventoryServer.services.UserService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(val userService: UserService) {

    @RequestMapping(value = ["/users"], method = [RequestMethod.GET],
        headers = ["Accept=application/json;charset=UTF-8"],
        produces = ["application/json"])
    @ResponseBody
    fun inventory():List<User>{
        return userService.all()
    }
}