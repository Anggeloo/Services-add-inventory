package com.addiventory.services_add_inventory.Services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.addiventory.services_add_inventory.Models.ApiResponse;
import com.addiventory.services_add_inventory.Models.Inventory;
import com.addiventory.services_add_inventory.Repository.InventoryAddResitory;

@Service
public class InventoryAddService {

    private final RestTemplate restTemplate;
    private final InventoryAddResitory _repository;

    // El RestTemplate es inyectado a través del constructor
    @Autowired
    public InventoryAddService(RestTemplate restTemplate, InventoryAddResitory repository) {
        this.restTemplate = restTemplate; // Se inicializa en el constructor
        this._repository = repository;
    }

    public ApiResponse<Inventory> addInventory(Inventory inventory) {
        boolean exists = checkProductExists(inventory.getProductCode());
        if (!exists) {
            return new ApiResponse<Inventory>("error", null, "The product code does not exist in the system.");
        }
        long totalInventories = _repository.count();
    
        String generatedCode = "INV_" + (totalInventories + 1);
        inventory.setInventoryCode(generatedCode);
    
        inventory.setCreatedAt(LocalDateTime.now());
        inventory.setUpdatedAt(LocalDateTime.now());
    
        _repository.save(inventory);
    
        return new ApiResponse<Inventory>("success", inventory, "Product added successfully.");
    }
    

    private boolean checkProductExists(String codice) {
        //String url = "http://localhost:3000/products/byCodiceProducto?codice=" + codice; // local
        String url = "http://app_producto_search:3000/products/byCodiceProducto?codice=" + codice;
        try {
            Map<String, Object> response = restTemplate.getForObject(url, Map.class);
            String status = (String) response.get("status");
            if ("success".equals(status)) {
                List<Map<String, Object>> data = (List<Map<String, Object>>) response.get("data");
                return !data.isEmpty();  
            } else {
                return false;  
            }
        } catch (Exception e) {
            e.printStackTrace();  
            return false; 
        }
    }
}
