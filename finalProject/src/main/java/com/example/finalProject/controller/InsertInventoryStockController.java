package com.example.finalProject.controller;

import com.example.finalProject.dto.category.request.CreateInventoryDto;
import com.example.finalProject.dto.category.request.CreateInventoryStockDto;
import com.example.finalProject.dto.category.response.CreateInventoryResponseDto;
import com.example.finalProject.dto.category.response.InventoryStockResponse;
import com.example.finalProject.model.InventoryProduct;
import com.example.finalProject.service.InventoryService;
import com.example.finalProject.service.InventoryStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("stock")
public class InsertInventoryStockController {

    @Autowired
    private InventoryStock inventoryStock;

    @PostMapping("create")
    public ResponseEntity addStock(@RequestBody CreateInventoryStockDto createInventoryStockDto){
        try{
            InventoryStockResponse responseDto = inventoryStock.addStock(createInventoryStockDto);
            return ResponseEntity.status(responseDto.getStatusCode()).body(responseDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping()
    public ResponseEntity getCategories(){
        return  ResponseEntity.ok().body(inventoryStock.getDataList());
    }

}
