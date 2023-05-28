package com.example.finalProject.service;

import com.example.finalProject.dto.category.request.CreateInventoryDto;
import com.example.finalProject.dto.category.response.CreateInventoryResponseDto;
import com.example.finalProject.model.InventoryProduct;
import com.example.finalProject.repo.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepo inventoryRepo;

    public CreateInventoryResponseDto saveCategory(CreateInventoryDto createInventoryDto) throws Exception{

        if (createInventoryDto.getCategoryName().length() > 50){
            throw  new Exception("Please input categoryName less than 50");
        }else if(createInventoryDto.getCategoryName().matches("[0-9]+]")){
            throw new Exception("categoryName must be alphabetically");
        }

        InventoryProduct inventoryProduct = new InventoryProduct();
        inventoryProduct.setProductName(createInventoryDto.getCategoryName());
        inventoryProduct.setCreated_at(new Date());
        inventoryProduct.setUpdated_at(new Date());

        try{
            inventoryRepo.save(inventoryProduct);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        CreateInventoryResponseDto response = new CreateInventoryResponseDto();
        response.setCategoryId(inventoryProduct.getProductId());
        response.setCategoryName(inventoryProduct.getProductName());
        response.setStatusCode(HttpStatus.CREATED.value());
        response.setResult("Category Product created successfully");
        return response;
    }

    public List<CreateInventoryResponseDto> getDataList(){
        List<InventoryProduct> inventoryProducts = inventoryRepo.findAll();
        List<CreateInventoryResponseDto> responseList = new ArrayList<>();

        for (InventoryProduct ip : inventoryProducts){
            CreateInventoryResponseDto responseDto = new CreateInventoryResponseDto();
            responseDto.setCategoryId(ip.getProductId());
            responseDto.setCategoryName(ip.getProductName());
            responseDto.setResult("Success");
            responseDto.setStatusCode(HttpStatus.OK.value());
            responseList.add(responseDto);
        }
        return responseList;
    }

    public InventoryProduct updateName(InventoryProduct inventoryProduct){
        Optional<InventoryProduct> product = inventoryRepo.findById(inventoryProduct.getProductId());
        product.get().setProductName(inventoryProduct.getProductName());
        product.get().setUpdated_at(new Date());
        return product.get();
    }

    public InventoryProduct updateStatus(InventoryProduct inventoryProduct){
        Optional<InventoryProduct> product = inventoryRepo.findById(inventoryProduct.getProductId());
        product.get().setStatus(inventoryProduct.getStatus());
        product.get().setUpdated_at(new Date());
        return product.get();
    }

    public String delete ( int productId){
        Optional<InventoryProduct> product = inventoryRepo.findById(productId);
        inventoryRepo.delete(product.get());

        return "Product has been delete successfully";
    }
}
