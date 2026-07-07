package com.example.PosSystemMart.Controller;

import com.example.PosSystemMart.DTO.StockRequest;
import com.example.PosSystemMart.DTO.StockResponse;
import com.example.PosSystemMart.Service.StockService;
import com.example.PosSystemMart.Util.APIResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
@CrossOrigin(origins = "*")
public class StockController {

    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping
    public ResponseEntity<APIResponse<StockResponse>> createStock(@RequestBody @Valid StockRequest request) {
        StockResponse stock = stockService.createStock(request);
        APIResponse<StockResponse> response = APIResponse.<StockResponse>builder()
                .status(HttpStatus.CREATED.value())
                .message("Stock created successfully")
                .data(stock)
                .build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<StockResponse>> updateStock(
            @PathVariable Long id,
            @RequestBody @Valid StockRequest request) {
        StockResponse stock = stockService.updateStock(id, request);
        APIResponse<StockResponse> response = APIResponse.<StockResponse>builder()
                .status(HttpStatus.OK.value())
                .message("Stock updated successfully")
                .data(stock)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<StockResponse>>> getAllStocks() {
        List<StockResponse> stocks = stockService.getAllStocks();
        APIResponse<List<StockResponse>> response = APIResponse.<List<StockResponse>>builder()
                .status(HttpStatus.OK.value())
                .message("Stocks retrieved successfully")
                .data(stocks)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<StockResponse>> getStockById(@PathVariable Long id) {
        StockResponse stock = stockService.getStockById(id);
        APIResponse<StockResponse> response = APIResponse.<StockResponse>builder()
                .status(HttpStatus.OK.value())
                .message("Stock retrieved successfully")
                .data(stock)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Void>> deleteStock(@PathVariable Long id) {
        stockService.deleteStock(id);
        APIResponse<Void> response = APIResponse.<Void>builder()
                .status(HttpStatus.OK.value())
                .message("Stock deleted successfully")
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
