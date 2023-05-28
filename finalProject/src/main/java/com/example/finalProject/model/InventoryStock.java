package com.example.finalProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InventoryStock extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int idProduct;

    private String namaProduct;
    private int supplierCode;
    private int productCode;
    private String description;
    private int productId;
    private String productName;
    private String qty;



}
