package com.example.finalProject.controller;

import com.example.finalProject.dto.category.request.CreateInventoryDto;
import com.example.finalProject.dto.category.request.CreateInventorySupplierDto;
import com.example.finalProject.dto.category.response.CreateInventoryResponseDto;
import com.example.finalProject.dto.category.response.CreateInventorySupplierResponseDto;
import com.example.finalProject.model.InventoryProduct;
import com.example.finalProject.model.InventorySupplier;
import com.example.finalProject.service.InventoryService;
import com.example.finalProject.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("supplier")
public class InsertSupplierInventoryController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping("create")
    public ResponseEntity addCategory(@RequestBody CreateInventorySupplierDto createInventorySupplierDto){
        try{
            CreateInventorySupplierResponseDto responseDto = supplierService.saveSupplier(createInventorySupplierDto);
            return ResponseEntity.status(responseDto.getStatusCode()).body(responseDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping()
    public ResponseEntity getCategories(){
        return  ResponseEntity.ok().body(supplierService.getSupplier());
    }

    @PutMapping("updateName")
    public ResponseEntity updateName (@RequestBody InventorySupplier inventorySupplier){
        return ResponseEntity.ok().body(supplierService.updateName(inventorySupplier));
    }

    @PutMapping("updateStatus")
    public ResponseEntity updateStatus (@RequestBody InventorySupplier inventorySupplier){
        return ResponseEntity.ok().body(supplierService.updateStatus(inventorySupplier));
    }

    @DeleteMapping()
    public ResponseEntity delete(@RequestParam("supplierCode") int supplierCode){
        return ResponseEntity.ok().body(supplierService.delete(supplierCode));
    }
}
