package com.example.PosSystemMart.Service;

import com.example.PosSystemMart.DTO.BrandRequest;
import com.example.PosSystemMart.DTO.BrandResponse;

import java.util.List;

public interface BrandService {
    BrandResponse createBrand(BrandRequest request);
    BrandResponse updateBrand(Long id, BrandRequest request);
    List<BrandResponse> getAllBrands();
    BrandResponse getBrandById(Long id);
    void deleteBrand(Long id);
}
