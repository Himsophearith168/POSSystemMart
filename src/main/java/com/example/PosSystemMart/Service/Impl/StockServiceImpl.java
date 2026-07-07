package com.example.PosSystemMart.Service.Impl;

import com.example.PosSystemMart.DTO.StockRequest;
import com.example.PosSystemMart.DTO.StockResponse;
import com.example.PosSystemMart.Exception.ResourceNotFoundException;
import com.example.PosSystemMart.Mapper.StockMapper;
import com.example.PosSystemMart.Model.StockModel;
import com.example.PosSystemMart.Repository.StockRepository;
import com.example.PosSystemMart.Service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;

    @Autowired
    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public StockResponse createStock(StockRequest request) {
        StockModel stock = StockMapper.toEntity(request);
        StockModel savedStock = stockRepository.save(stock);
        return StockMapper.toDto(savedStock);
    }

    @Override
    public StockResponse updateStock(Long id, StockRequest request) {
        StockModel existingStock = stockRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Stock not found with id: " + id));

        existingStock.setStockQuantity(request.getStockQuantity());

        StockModel savedStock = stockRepository.save(existingStock);
        return StockMapper.toDto(savedStock);
    }

    @Override
    public List<StockResponse> getAllStocks() {
        List<StockModel> stocks = stockRepository.findAll();
        return stocks.stream()
                .map(StockMapper::toDto)
                .toList();
    }

    @Override
    public StockResponse getStockById(Long id) {
        StockModel stock = stockRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Stock not found with id: " + id));
        return StockMapper.toDto(stock);
    }

    @Override
    public void deleteStock(Long id) {
        StockModel stock = stockRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Stock not found with id: " + id));
        stockRepository.delete(stock);
    }
}
