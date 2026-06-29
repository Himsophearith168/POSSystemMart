package com.example.PosSystemMart.Service;

import com.example.PosSystemMart.Dto.ProductRequest;
import com.example.PosSystemMart.Model.ProductModel;
import java.io.IOException;
import java.util.List;

public interface ProductService {
    ProductModel createProduct(ProductRequest request) throws IOException;
    ProductModel updateProduct(Long id, ProductRequest request) throws IOException;
    List<ProductModel> getAllProducts();
    ProductModel getProductById(Long id);
    void deleteProduct(Long id) throws IOException;
}
