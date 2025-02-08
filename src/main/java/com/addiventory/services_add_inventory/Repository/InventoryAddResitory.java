package com.addiventory.services_add_inventory.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.addiventory.services_add_inventory.Models.Inventory;

public interface InventoryAddResitory extends JpaRepository<Inventory, Integer>{
    
}
