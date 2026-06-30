package com.example.PosSystemMart.Service.Impl;

import com.example.PosSystemMart.DTO.BrandRequest;
import com.example.PosSystemMart.DTO.BrandResponse;
import com.example.PosSystemMart.Exception.ResourceNotFoundException;
import com.example.PosSystemMart.Mapper.BrandMapper;
import com.example.PosSystemMart.Model.BrandModel;
import com.example.PosSystemMart.Repository.BrandRepository;
import com.example.PosSystemMart.Service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public BrandResponse createBrand(BrandRequest request) {
        if (brandRepository.existsByBrandName(request.getBrandName())) {
            throw new IllegalArgumentException("Brand with name " + request.getBrandName() + " already exists.");
        }

        BrandModel brand = BrandMapper.toEntity(request);
        BrandModel savedBrand = brandRepository.save(brand);
        return BrandMapper.toResponse(savedBrand);
    }

    @Override
    public BrandResponse updateBrand(Long id, BrandRequest request) {
        BrandModel existingBrand = brandRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Brand not found with id: " + id));

        if (!existingBrand.getBrandName().equalsIgnoreCase(request.getBrandName()) &&
                brandRepository.existsByBrandName(request.getBrandName())) {
            throw new IllegalArgumentException("Brand with name " + request.getBrandName() + " already exists.");
        }

        existingBrand.setBrandName(request.getBrandName());
        existingBrand.setBrandDescription(request.getBrandDescription());

        BrandModel savedBrand = brandRepository.save(existingBrand);
        return BrandMapper.toResponse(savedBrand);
    }

    @Override
    public List<BrandResponse> getAllBrands() {
        List<BrandModel> brands = brandRepository.findAll();
        return brands.stream()
                .map(BrandMapper::toResponse)
                .toList();
    }

    @Override
    public BrandResponse getBrandById(Long id) {
        BrandModel brand = brandRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Brand not found with id: " + id));
        return BrandMapper.toResponse(brand);
    }

    @Override
    public void deleteBrand(Long id) {
        BrandModel brand = brandRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Brand not found with id: " + id));
        brandRepository.delete(brand);
    }
}
