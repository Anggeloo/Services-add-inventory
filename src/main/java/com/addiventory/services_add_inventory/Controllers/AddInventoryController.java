package com.addiventory.services_add_inventory.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.addiventory.services_add_inventory.Models.ApiResponse;
import com.addiventory.services_add_inventory.Models.Inventory;
import com.addiventory.services_add_inventory.Services.InventoryAddService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/inventory/add")
@Tag(name = "Inventory Add", description = "Inventory Add Operations")
public class AddInventoryController {
    @Autowired
    private InventoryAddService _service;

    @PostMapping
    @Operation(summary = "Add inventory", description = "Add a new inventory to the system")
    public ApiResponse<Inventory> addInventory(@RequestBody Inventory inventory) {
        ApiResponse<Inventory> response = _service.addInventory(inventory);
        return response;
    }
}
