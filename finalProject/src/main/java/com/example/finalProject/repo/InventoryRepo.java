package com.example.finalProject.repo;


import com.example.finalProject.model.InventoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InventoryRepo extends JpaRepository<InventoryProduct, Integer> {

  @Query(value = "select inventoryId from inventoryProduct where inventoryName = ?1", nativeQuery = true)
  public int getCategoryId(String categoryName);


}
