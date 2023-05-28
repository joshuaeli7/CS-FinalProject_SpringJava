package com.example.finalProject.dto.category.response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InventoryStockResponse {

    private int idProduct;

    private String namaProduct;
    private String supplierCode;
    private String productCode;
    private String description;
    private int productId;
    private String productName;
    private String qty;

    private int statusCode;
    private String result;

}
