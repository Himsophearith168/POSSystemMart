package com.example.PosSystemMart.Repository;

import com.example.PosSystemMart.Model.ProductModel;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {

    /**
     * Filter products whose name contains the given string (case-insensitive).
     */
    public static Specification<ProductModel> hasName(String name) {
        return (root, query, cb) -> {
            if (name == null || name.isBlank()) return cb.conjunction();
            return cb.like(cb.lower(root.get("productName")), "%" + name.toLowerCase() + "%");
        };
    }

    /**
     * Filter products by category ID.
     */
    public static Specification<ProductModel> hasCategoryId(Long categoryId) {
        return (root, query, cb) -> {
            if (categoryId == null) return cb.conjunction();
            return cb.equal(root.get("categoryId").get("id"), categoryId);
        };
    }

    /**
     * Filter products by brand ID.
     */
    public static Specification<ProductModel> hasBrandId(Long brandId) {
        return (root, query, cb) -> {
            if (brandId == null) return cb.conjunction();
            return cb.equal(root.get("brandId").get("id"), brandId);
        };
    }

    /**
     * Filter products by stock ID.
     */
    public static Specification<ProductModel> hasStockId(Long stockId) {
        return (root, query, cb) -> {
            if (stockId == null) return cb.conjunction();
            return cb.equal(root.get("stockId").get("id"), stockId);
        };
    }

    /**
     * Filter products by minimum price (inclusive).
     */
    public static Specification<ProductModel> hasPriceGreaterThanOrEqual(Double minPrice) {
        return (root, query, cb) -> {
            if (minPrice == null) return cb.conjunction();
            return cb.greaterThanOrEqualTo(root.get("price"), minPrice);
        };
    }

    /**
     * Filter products by maximum price (inclusive).
     */
    public static Specification<ProductModel> hasPriceLessThanOrEqual(Double maxPrice) {
        return (root, query, cb) -> {
            if (maxPrice == null) return cb.conjunction();
            return cb.lessThanOrEqualTo(root.get("price"), maxPrice);
        };
    }
}
