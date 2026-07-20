package com.example.PosSystemMart.Repository;

import com.example.PosSystemMart.Model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long>,
        JpaSpecificationExecutor<ProductModel> {
    Optional<ProductModel> findByBarcode(Integer barcode);
    boolean existsByBarcode(Integer barcode);
}
