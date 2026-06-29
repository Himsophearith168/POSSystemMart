package com.example.PosSystemMart.Service;

import com.example.PosSystemMart.DTO.ProductRequest;
import com.example.PosSystemMart.DTO.ProductResponse;
import java.io.IOException;
import java.util.List;

public interface ProductService {
    ProductResponse createProduct(ProductRequest request) throws IOException;
    ProductResponse updateProduct(Long id, ProductRequest request) throws IOException;
    List<ProductResponse> getAllProducts();
    ProductResponse getProductById(Long id);
    void deleteProduct(Long id) throws IOException;
}
