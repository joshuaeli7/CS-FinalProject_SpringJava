package com.example.finalProject.repo;

import com.example.finalProject.model.InventoryProduct;
import com.example.finalProject.model.InventorySupplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InventorySupplierRepo extends JpaRepository<InventorySupplier, Integer> {

    @Query(value = "select supplierCode from inventorySupplier where supplierName = ?1", nativeQuery = true)
    public int getSupplierCode(String supplierName);

}
