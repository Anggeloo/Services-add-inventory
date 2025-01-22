package com.addiventory.services_add_inventory.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.addiventory.services_add_inventory.Models.ApiResponse;
import com.addiventory.services_add_inventory.Models.Inventory;
import com.addiventory.services_add_inventory.Services.InventoryAddService;

@RestController
@RequestMapping("/inventory/add")
public class AddInventoryController {
    @Autowired
    private InventoryAddService _service;

    @PostMapping
    public ApiResponse<Inventory> addInventory(@RequestBody Inventory inventory) {
        ApiResponse<Inventory> response = _service.addInventory(inventory);
        return response;
    }
}
