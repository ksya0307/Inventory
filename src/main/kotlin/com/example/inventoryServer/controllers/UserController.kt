package com.example.inventoryServer.controllers

import com.example.inventoryServer.entities.Users
import com.example.inventoryServer.services.UserService
import io.micrometer.core.annotation.Timed
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/users")
class UserController(val userService: UserService) {

    @GetMapping
    @ResponseBody
    @Timed(value = "users.time", description = "Time taken to return all users")
    fun getAll():List<Users>{
        return userService.all()
    }

    @RequestMapping(value = ["/{id}"], method = [RequestMethod.GET],
        headers = ["Accept=application/json;charset=UTF-8"],
        produces = ["application/json"])
    @ResponseBody
    fun getById(@PathVariable id:Long): Users {
        return userService.getById(id)
    }
}