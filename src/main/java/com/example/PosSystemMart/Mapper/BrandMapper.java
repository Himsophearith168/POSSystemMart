package com.example.PosSystemMart.Mapper;

import com.example.PosSystemMart.DTO.BrandRequest;
import com.example.PosSystemMart.DTO.BrandResponse;
import com.example.PosSystemMart.Model.BrandModel;
import org.springframework.stereotype.Component;

@Component
public class BrandMapper {
    public BrandModel toEntity(BrandRequest dto) {
        if (dto == null) {
            return null;
        }
        return BrandModel.builder()
                .brandName(dto.getBrandName())
                .brandDescription(dto.getBrandDescription())
                .build();
    }
    public BrandResponse toResponse(BrandModel dto) {
        if (dto == null) {
            return null;
        }
        BrandResponse response = new BrandResponse();
        response.setBrandName(dto.getBrandName());
        response.setBrandDescription(dto.getBrandDescription());
        return response;
    }
}
