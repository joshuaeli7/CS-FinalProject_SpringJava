package com.example.finalProject.service;

import com.example.finalProject.dto.category.request.CreateInventoryDto;
import com.example.finalProject.dto.category.request.CreateInventorySupplierDto;
import com.example.finalProject.dto.category.response.CreateInventoryResponseDto;
import com.example.finalProject.dto.category.response.CreateInventorySupplierResponseDto;
import com.example.finalProject.model.InventorySupplier;
import com.example.finalProject.model.InventorySupplier;
import com.example.finalProject.repo.InventorySupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class SupplierService {

    @Autowired
    private InventorySupplierRepo inventorySupplierRepo;

    public CreateInventorySupplierResponseDto saveSupplier(CreateInventorySupplierDto createInventorySupplierDto) throws Exception{

        if (createInventorySupplierDto.getSupplierName().length() > 50){
            throw  new Exception("Please input categoryName less than 50");
        }else if(createInventorySupplierDto.getSupplierName().matches("[0-9]+]")){
            throw new Exception("categoryName must be alphabetically");
        }

        InventorySupplier inventorySupplier = new InventorySupplier();
        inventorySupplier.setSupplierName(createInventorySupplierDto.getSupplierName());
        inventorySupplier.setCreated_at(new Date());
        inventorySupplier.setUpdated_at(new Date());

        try{
            inventorySupplierRepo.save(inventorySupplier);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        CreateInventorySupplierResponseDto response = new CreateInventorySupplierResponseDto();
        response.setSupplierCode(inventorySupplier.getSupplierCode());
        response.setSupplierName(inventorySupplier.getSupplierName());
        response.setStatusCode(HttpStatus.CREATED.value());
        response.setResult("Supplier created successfully");
        return response;
    }

    public List<CreateInventorySupplierResponseDto> getSupplier(){
        List<InventorySupplier> inventorySuppliers = inventorySupplierRepo.findAll();
        List<CreateInventorySupplierResponseDto> responseList = new ArrayList<>();

        for (InventorySupplier ip : inventorySuppliers){
            CreateInventorySupplierResponseDto responseDto = new CreateInventorySupplierResponseDto();
            responseDto.setSupplierCode(ip.getSupplierCode());
            responseDto.setSupplierName(ip.getSupplierName());
            responseDto.setResult("Success");
            responseDto.setStatusCode(HttpStatus.OK.value());
            responseList.add(responseDto);
        }
        return responseList;
    }

    public InventorySupplier updateName(InventorySupplier inventorySupplier){
        Optional<InventorySupplier> product = inventorySupplierRepo.findById(inventorySupplier.getSupplierCode());
        product.get().setSupplierName(inventorySupplier.getSupplierName());
        product.get().setUpdated_at(new Date());
        return product.get();
    }

    public InventorySupplier updateStatus(InventorySupplier inventorySupplier){
        Optional<InventorySupplier> product = inventorySupplierRepo.findById(inventorySupplier.getSupplierCode());
        product.get().setStatus(inventorySupplier.getStatus());
        product.get().setUpdated_at(new Date());
        return product.get();
    }

    public String delete ( int productId){
        Optional<InventorySupplier> product = inventorySupplierRepo.findById(productId);
        inventorySupplierRepo.delete(product.get());

        return "Supplier has been Remove successfully";
    }
}
