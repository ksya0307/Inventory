package com.example.inventoryServer.controllers

import com.example.inventoryServer.services.InventoryService
import com.example.inventoryServer.entities.Inventory
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI
import java.net.URISyntaxException
import kotlin.jvm.Throws


@RestController
@RequestMapping("/api")
class InventoryController(val inventoryService: InventoryService) {

    @RequestMapping(value = ["/inventory"], method = [RequestMethod.GET],
        headers = ["Accept=application/json;charset=UTF-8"],
        produces = ["application/json"])
    @ResponseBody
    fun inventory():List<Inventory>{
        return inventoryService.all()
    }

    @RequestMapping(value = ["/inventoryById"], method = [RequestMethod.GET],
        headers = ["Accept=application/json;charset=UTF-8"],
        produces = ["application/json"])
    @ResponseBody
    fun inventoryById(@RequestParam(name = "id") id:Int):Inventory{
        return inventoryService.inventoryById(id)
    }

    @RequestMapping(value = ["/addInventory"], method = [RequestMethod.POST],
        headers = ["Accept=application/json;charset=UTF-8"],
        produces = [MediaType.APPLICATION_JSON_VALUE])
    @Throws(URISyntaxException::class)
    fun addInventory(@RequestBody inventory: Inventory):ResponseEntity<Inventory> {
        val createInventory:Inventory =  inventoryService.addInventory(inventory)
        return if(createInventory.equals(null)){
            ResponseEntity.notFound().build()
        }else{
            val uri: URI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createInventory.id)
                .toUri()
            ResponseEntity.created(uri).body(createInventory)
        }
    }
}