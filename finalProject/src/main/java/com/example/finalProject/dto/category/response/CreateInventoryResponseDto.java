package com.example.finalProject.dto.category.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateInventoryResponseDto {

    private int categoryId;
    private String categoryName;
    private String status;

    private int statusCode;
    private String result;
}
