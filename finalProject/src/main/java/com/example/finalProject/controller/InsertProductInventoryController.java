package com.example.finalProject.controller;

import com.example.finalProject.dto.category.request.CreateInventoryDto;
import com.example.finalProject.dto.category.response.CreateInventoryResponseDto;
import com.example.finalProject.model.InventoryProduct;
import com.example.finalProject.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("category")
public class InsertProductInventoryController {
    @Autowired
    private InventoryService inventoryService;

    @PostMapping("create")
    public ResponseEntity addCategory(@RequestBody CreateInventoryDto createInventoryDto){
        try{
            CreateInventoryResponseDto responseDto = inventoryService.saveCategory(createInventoryDto);
            return ResponseEntity.status(responseDto.getStatusCode()).body(responseDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping()
    public ResponseEntity getCategories(){
        return  ResponseEntity.ok().body(inventoryService.getDataList());
    }

    @PutMapping("updateName")
    public ResponseEntity updateName (@RequestBody InventoryProduct inventoryProduct){
        return ResponseEntity.ok().body(inventoryService.updateName(inventoryProduct));
    }

    @PutMapping("updateStatus")
    public ResponseEntity updateStatus (@RequestBody InventoryProduct inventoryProduct){
        return ResponseEntity.ok().body(inventoryService.updateStatus(inventoryProduct));
    }

    @DeleteMapping()
    public ResponseEntity delete(@RequestParam("productId") int productId){
        return ResponseEntity.ok().body(inventoryService.delete(productId));
    }
}
