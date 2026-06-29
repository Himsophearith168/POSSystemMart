package com.example.PosSystemMart.Mapper;

import com.example.PosSystemMart.DTO.ProductRequest;
import com.example.PosSystemMart.DTO.ProductResponse;
import com.example.PosSystemMart.Model.ProductModel;

public class ProductMapper {

    public static ProductModel toEntity(ProductRequest request, String imageName) {
        if (request == null) {
            return null;
        }
        return ProductModel.builder()
                .productName(request.getProductName())
                .productDescription(request.getProductDescription())
                .barcode(request.getBarcode())
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .productImage(imageName)
                .categoryId(request.getCategoryId())
                .stockId(request.getStockId())
                .brandId(request.getBrandId())
                .build();
    }

    public static ProductResponse toResponse(ProductModel model) {
        if (model == null) {
            return null;
        }
        return ProductResponse.builder()
                .id(model.getId())
                .productName(model.getProductName())
                .productDescription(model.getProductDescription())
                .barcode(model.getBarcode())
                .price(model.getPrice())
                .quantity(model.getQuantity())
                .productImage(model.getProductImage())
                .categoryId(model.getCategoryId())
                .stockId(model.getStockId())
                .brandId(model.getBrandId())
                .build();
    }
}
