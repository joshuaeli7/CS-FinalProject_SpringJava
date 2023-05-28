package com.example.finalProject.dto.category.request;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateInventoryStockDto {

    private int idProduct;

    private String namaProduct;
    private int supplierCode;
    private int productCode;
    private String description;
    private int productId;
    private String productName;
    private String supplierName;
    private String qty;

    private int statusCode;
    private String result;
}
