package com.example.InventoryServer.controllers
import com.example.InventoryServer.entities.User
import com.example.InventoryServer.services.UserService
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/auth")
class UserController(val userService: UserService) {

    @GetMapping("users")
    @PreAuthorize("hasAuthority('USERS:READ')")
    @ResponseBody
    fun getUsers():List<User>{
        return userService.all()
    }

    @GetMapping("users/{userId}")
    fun getUser(@PathVariable("userId") userId: Int): User? {
        return userService.getUser(userId)
    }

    @GetMapping("test")
    fun test(): String = "Hewwo"

    /*@PostMapping("/register")
    fun register(@RequestBody body: RegisterDTO): ResponseEntity<User> {
        val user = User()
        return ResponseEntity.ok(this.userService.register(user))
    }*/
}

