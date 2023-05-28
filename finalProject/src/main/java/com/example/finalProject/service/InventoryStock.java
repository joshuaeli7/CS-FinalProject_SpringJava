package com.example.finalProject.service;

import com.example.finalProject.dto.category.request.CreateInventoryStockDto;
import com.example.finalProject.dto.category.response.InventoryStockResponse;
import com.example.finalProject.model.InventoryProduct;
import com.example.finalProject.repo.InventoryRepo;
import com.example.finalProject.repo.InventoryStockRepo;
import com.example.finalProject.repo.InventorySupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryStock {

    @Autowired
    private InventoryStockRepo inventoryStockRepo;

    @Autowired
    private InventoryRepo inventoryRepo;

    @Autowired
    private InventorySupplierRepo inventorySupplierRepo;

    public InventoryStockResponse addStock(CreateInventoryStockDto createInventoryStockDto){

        com.example.finalProject.model.InventoryStock inventoryStock = new com.example.finalProject.model.InventoryStock();
        inventoryStock.setNamaProduct(createInventoryStockDto.getNamaProduct());
        inventoryStock.setQty(createInventoryStockDto.getQty());
        inventoryStock.setDescription(createInventoryStockDto.getDescription());

        int productCode = inventoryRepo.getCategoryId(createInventoryStockDto.getProductName());
        int supplierCode = inventorySupplierRepo.getSupplierCode(createInventoryStockDto.getSupplierName());

        inventoryStock.setProductCode(productCode);
        inventoryStock.setSupplierCode(supplierCode);

        InventoryStockResponse response = new InventoryStockResponse();
        response.setProductName(createInventoryStockDto.getProductName());
        response.setDescription(createInventoryStockDto.getDescription());
        Optional<InventoryProduct> inventoryProduct = inventoryRepo.findById(productCode);

        return response;
    }

    public List<CreateInventoryStockDto> getDataList(){
        List<com.example.finalProject.model.InventoryStock> inventoryStocks = inventoryStockRepo.findAll();
        List<CreateInventoryStockDto> inventoryStockDto = new ArrayList<>();

        for(com.example.finalProject.model.InventoryStock is : inventoryStocks){
            CreateInventoryStockDto responseDto = new CreateInventoryStockDto();
            responseDto.setProductCode(is.getProductCode());
            responseDto.setProductName(is.getProductName());
            responseDto.setSupplierCode(is.getSupplierCode());
            responseDto.setDescription(is.getDescription());
            responseDto.setResult("Success");
            responseDto.setStatusCode(HttpStatus.OK.value());
            inventoryStockDto.add(responseDto);
        }
        return inventoryStockDto;
    }
}
