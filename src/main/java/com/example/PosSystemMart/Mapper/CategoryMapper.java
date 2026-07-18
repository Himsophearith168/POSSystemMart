package com.example.PosSystemMart.Mapper;

import com.example.PosSystemMart.DTO.CategoryRequest;
import com.example.PosSystemMart.DTO.CategoryResponse;
import com.example.PosSystemMart.Model.CategoryModel;

public class CategoryMapper {

    public static CategoryModel toEntity(CategoryRequest dto) {
        if (dto == null) {
            return null;
        }
        return CategoryModel.builder()
                .categoryName(dto.getCategoryName())
                .categoryDescription(dto.getCategoryDescription())
                .build();
    }

    public static CategoryResponse toResponse(CategoryModel model) {
        if (model == null) {
            return null;
        }
        return CategoryResponse.builder()
                .id(model.getId())
                .categoryName(model.getCategoryName())
                .categoryDescription(model.getCategoryDescription())
                .build();
    }
}
