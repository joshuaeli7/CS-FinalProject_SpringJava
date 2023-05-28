package com.example.finalProject.repo;

import com.example.finalProject.model.InventoryStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryStockRepo extends JpaRepository<InventoryStock, Integer> {
}
