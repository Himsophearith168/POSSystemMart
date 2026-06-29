package com.example.PosSystemMart.DTO;

import com.example.PosSystemMart.Model.BrandModel;
import com.example.PosSystemMart.Model.CategoryModel;
import com.example.PosSystemMart.Model.StockModel;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    @NotBlank(message = "Product name is required")
    private String productName;

    private String productDescription;

    @NotNull(message = "Barcode is required")
    private Integer barcode;

    @NotNull(message = "Price is required")
    @Min(value = 0, message = "Price cannot be negative")
    private Double price;

    @NotNull(message = "Quantity is required")
    @Min(value = 0, message = "Quantity cannot be negative")
    private Integer quantity;

    @NotNull(message = "Category ID is required")
    private CategoryModel categoryId;
    @NotNull(message = "Stock ID is required")
    private StockModel stockId;
    @NotNull(message = "Brand ID is required")
    private BrandModel brandId;

    private MultipartFile image;
}
