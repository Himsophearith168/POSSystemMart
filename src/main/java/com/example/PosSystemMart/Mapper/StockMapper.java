package com.example.PosSystemMart.Mapper;

import com.example.PosSystemMart.DTO.StockRequest;
import com.example.PosSystemMart.DTO.StockResponse;
import com.example.PosSystemMart.Model.StockModel;

public class StockMapper {
    public static StockModel toEntity (StockRequest stockRequest) {
        if (stockRequest == null) {
            return null;
        }
        return StockModel.builder()
                .stockQuantity(stockRequest.getStockQuantity())
                .build();
    }
    public static StockResponse toDto (StockModel stockModel) {
        if (stockModel == null) {
            return null;
        }
        return StockResponse.builder()
                .stockId(stockModel.getId())
                .stockQuantity(stockModel.getStockQuantity())
                .build();
    }

}
