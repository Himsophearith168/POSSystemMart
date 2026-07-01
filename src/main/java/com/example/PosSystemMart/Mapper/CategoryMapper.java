package com.example.PosSystemMart.Mapper;

import com.example.PosSystemMart.DTO.CategoryRequest;
import com.example.PosSystemMart.DTO.CategoryResponse;
import com.example.PosSystemMart.Model.CategoryModel;
import jdk.jfr.Category;

public class CategoryMapper {
    public static CategoryModel toEntity(CategoryRequest dto) {
        if (dto == null) {
            return null;
        }
        CategoryModel categoryModel = new CategoryModel();
        return categoryModel.builder()
                .categoryName(dto.getCategoryName())
                .categoryDescription(dto.getCategoryDescription())
                .build();
    }
    public static CategoryResponse toResponse(CategoryModel dto) {
        if (dto == null) {
            return null;
        }
        CategoryResponse categoryResponse = new CategoryResponse();
        return categoryResponse.builder()
                .id(dto.getId())
                .categoryName(dto.getCategoryName())
                .categoryDescription(dto.getCategoryDescription())
                .build();
    }
}
