package com.example.InventoryServer.controllers

import com.example.InventoryServer.entities.Inventory
import com.example.InventoryServer.services.InventoryService
import org.springframework.web.bind.annotation.*

@RestController
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
}