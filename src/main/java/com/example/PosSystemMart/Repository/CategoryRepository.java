package com.example.PosSystemMart.Repository;

import com.example.PosSystemMart.Model.BrandModel;
import com.example.PosSystemMart.Model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository  extends JpaRepository<CategoryModel, Long> {
    Optional<CategoryModel> findByCategoryName(String categoryName);
    boolean existsByCategoryName(String categoryName);
}
