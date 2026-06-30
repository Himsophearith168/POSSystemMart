package com.example.PosSystemMart.DTO;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BrandResponse {
    private Long id;
    private String brandName;
    private String brandDescription;
}
