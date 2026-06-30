package com.example.PosSystemMart.Mapper;

import com.example.PosSystemMart.DTO.BrandRequest;
import com.example.PosSystemMart.DTO.BrandResponse;
import com.example.PosSystemMart.Model.BrandModel;

public class BrandMapper {

    public static BrandModel toEntity(BrandRequest request) {
        if (request == null) {
            return null;
        }
        return BrandModel.builder()
                .brandName(request.getBrandName())
                .brandDescription(request.getBrandDescription())
                .build();
    }

    public static BrandResponse toResponse(BrandModel model) {
        if (model == null) {
            return null;
        }
        return BrandResponse.builder()
                .id(model.getId())
                .brandName(model.getBrandName())
                .brandDescription(model.getBrandDescription())
                .build();
    }
}
