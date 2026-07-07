package com.example.PosSystemMart.Service;

import com.example.PosSystemMart.DTO.StockRequest;
import com.example.PosSystemMart.DTO.StockResponse;

import java.util.List;

public interface StockService {
    StockResponse createStock(StockRequest request);
    StockResponse updateStock(Long id, StockRequest request);
    List<StockResponse> getAllStocks();
    StockResponse getStockById(Long id);
    void deleteStock(Long id);
}
