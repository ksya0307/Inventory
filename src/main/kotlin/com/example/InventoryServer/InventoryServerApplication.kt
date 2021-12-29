package com.example.InventoryServer

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class InventoryServerApplication

fun main(args: Array<String>) {
	runApplication<InventoryServerApplication>(*args){
		setBannerMode(Banner.Mode.OFF)
	}
}
