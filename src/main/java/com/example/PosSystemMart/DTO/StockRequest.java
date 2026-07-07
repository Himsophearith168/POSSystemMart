package com.example.PosSystemMart.DTO;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockRequest {
    @NotNull(message = "Stock quantity is required")
    private Integer stockQuantity;
}
