package com.example.PosSystemMart.Service;

import com.example.PosSystemMart.Mapper.BrandMapper;
import com.example.PosSystemMart.Repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandService {
    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;



}

