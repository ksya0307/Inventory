package com.example.inventoryServer

import io.micrometer.core.aop.TimedAspect
import io.micrometer.core.instrument.MeterRegistry
import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean


@SpringBootApplication
class InventoryServerApplication

fun main(args: Array<String>) {
	runApplication<InventoryServerApplication>(*args){
		setBannerMode(Banner.Mode.OFF)
	}

}

@Bean
fun timedAspect(registry: MeterRegistry): TimedAspect {
	return TimedAspect(registry)
}