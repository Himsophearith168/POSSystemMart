package com.example.PosSystemMart.Service;

import com.example.PosSystemMart.DTO.CategoryRequest;
import com.example.PosSystemMart.DTO.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse createCategory(CategoryRequest request);
    List<CategoryResponse> getAllCategory();
    CategoryResponse updateCategory(Long id,CategoryRequest request);
}
