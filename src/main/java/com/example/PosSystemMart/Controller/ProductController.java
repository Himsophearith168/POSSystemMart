package com.example.PosSystemMart.Controller;

import com.example.PosSystemMart.DTO.ProductRequest;
import com.example.PosSystemMart.DTO.ProductResponse;
import com.example.PosSystemMart.Service.ProductService;
import com.example.PosSystemMart.Util.APIResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<APIResponse<ProductResponse>> createProduct(@ModelAttribute @Valid ProductRequest request) throws IOException {
        ProductResponse product = productService.createProduct(request);
        APIResponse<ProductResponse> response = APIResponse.<ProductResponse>builder()
                .status(HttpStatus.CREATED.value())
                .message("Product created successfully")
                .data(product)
                .build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<APIResponse<ProductResponse>> updateProduct(
            @PathVariable Long id,
            @ModelAttribute @Valid ProductRequest request) throws IOException {
        ProductResponse product = productService.updateProduct(id, request);
        APIResponse<ProductResponse> response = APIResponse.<ProductResponse>builder()
                .status(HttpStatus.OK.value())
                .message("Product updated successfully")
                .data(product)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<ProductResponse>>> getAllProducts() {
        List<ProductResponse> products = productService.getAllProducts();
        APIResponse<List<ProductResponse>> response = APIResponse.<List<ProductResponse>>builder()
                .status(HttpStatus.OK.value())
                .message("Products retrieved successfully")
                .data(products)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<ProductResponse>> getProductById(@PathVariable Long id) {
        ProductResponse product = productService.getProductById(id);
        APIResponse<ProductResponse> response = APIResponse.<ProductResponse>builder()
                .status(HttpStatus.OK.value())
                .message("Product retrieved successfully")
                .data(product)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Void>> deleteProduct(@PathVariable Long id) throws IOException {
        productService.deleteProduct(id);
        APIResponse<Void> response = APIResponse.<Void>builder()
                .status(HttpStatus.OK.value())
                .message("Product deleted successfully")
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
