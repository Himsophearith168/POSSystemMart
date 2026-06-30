package com.example.PosSystemMart.Repository;

import com.example.PosSystemMart.Model.BrandModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<BrandModel, Long> {
    Optional<BrandModel> findByBrandName(String brandName);
    boolean existsByBrandName(String brandName);
}
