package com.example.PosSystemMart.Service.Impl;

import com.example.PosSystemMart.DTO.ProductRequest;
import com.example.PosSystemMart.DTO.ProductResponse;
import com.example.PosSystemMart.Exception.ResourceNotFoundException;
import com.example.PosSystemMart.Mapper.ProductMapper;
import com.example.PosSystemMart.Model.ProductModel;
import com.example.PosSystemMart.Repository.ProductRepository;
import com.example.PosSystemMart.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final Path root = Paths.get("uploads");

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
        try {
            if (!Files.exists(root)) {
                Files.createDirectories(root);
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    @Override
    public ProductResponse createProduct(ProductRequest request) throws IOException {
        if (productRepository.existsByBarcode(request.getBarcode())) {
            throw new IllegalArgumentException("Product with barcode " + request.getBarcode() + " already exists.");
        }

        String imageName = null;
        if (request.getImage() != null && !request.getImage().isEmpty()) {
            imageName = saveImage(request.getImage());
        }

        ProductModel product = ProductMapper.toEntity(request, imageName);
        ProductModel savedProduct = productRepository.save(product);
        return ProductMapper.toResponse(savedProduct);
    }

    @Override
    public ProductResponse updateProduct(Long id, ProductRequest request) throws IOException {
        ProductModel existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
        if (!existingProduct.getBarcode().equals(request.getBarcode()) && 
            productRepository.existsByBarcode(request.getBarcode())) {
            throw new IllegalArgumentException("Product with barcode " + request.getBarcode() + " already exists.");
        }

        existingProduct.setProductName(request.getProductName());
        existingProduct.setProductDescription(request.getProductDescription());
        existingProduct.setBarcode(request.getBarcode());
        existingProduct.setPrice(request.getPrice());
        existingProduct.setQuantity(request.getQuantity());
        existingProduct.setCategoryId(request.getCategoryId());
        existingProduct.setStockId(request.getStockId());
        existingProduct.setBrandId(request.getBrandId());

        if (request.getImage() != null && !request.getImage().isEmpty()) {
            deleteOldImage(existingProduct.getProductImage());
            String imageName = saveImage(request.getImage());
            existingProduct.setProductImage(imageName);
        }

        ProductModel savedProduct = productRepository.save(existingProduct);
        return ProductMapper.toResponse(savedProduct);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<ProductModel> products = productRepository.findAll();
        return products.stream()
                .map(ProductMapper::toResponse)
                .toList();
    }

    @Override
    public ProductResponse getProductById(Long id) {
        ProductModel product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
        return ProductMapper.toResponse(product);
    }

    @Override
    public void deleteProduct(Long id) throws IOException {
        ProductModel product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
        deleteOldImage(product.getProductImage());
        productRepository.delete(product);
    }

    private String saveImage(MultipartFile file) throws IOException {
        String ext = getFileExtension(file.getOriginalFilename());
        String fileName = UUID.randomUUID().toString() + (ext.isEmpty() ? "" : "." + ext);
        Files.copy(file.getInputStream(), this.root.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
        return fileName;
    }

    private void deleteOldImage(String fileName) {
        if (fileName != null && !fileName.isEmpty()) {
            try {
                Path filePath = this.root.resolve(fileName);
                Files.deleteIfExists(filePath);
            } catch (IOException e) {
                System.err.println("Failed to delete image: " + fileName + ". Error: " + e.getMessage());
            }
        }
    }

    private String getFileExtension(String fileName) {
        if (fileName == null) return "";
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }
}
