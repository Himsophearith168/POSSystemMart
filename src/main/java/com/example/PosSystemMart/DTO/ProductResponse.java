package com.example.PosSystemMart.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private Long id;
    private String productName;
    private String productDescription;
    private Integer barcode;
    private Double price;
    private Integer quantity;
    private String productImage;
    private Long categoryId;
    private Long stockId;
    private Long brandId;
}
