package com.example.InventoryServer

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class InventoryServerApplication

fun main(args: Array<String>) {
	runApplication<InventoryServerApplication>(*args){
		setBannerMode(Banner.Mode.OFF)
	}

}
