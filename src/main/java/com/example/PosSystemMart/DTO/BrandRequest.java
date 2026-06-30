package com.example.PosSystemMart.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BrandRequest {
    @NotBlank(message = "Brand name is required")
    private String brandName;

    private String brandDescription;
}
