package com.example.PosSystemMart.Controller;

import com.example.PosSystemMart.DTO.BrandRequest;
import com.example.PosSystemMart.DTO.BrandResponse;
import com.example.PosSystemMart.Service.BrandService;
import com.example.PosSystemMart.Util.APIResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@CrossOrigin(origins = "*")
public class BrandController {

    private final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @PostMapping
    public ResponseEntity<APIResponse<BrandResponse>> createBrand(@RequestBody @Valid BrandRequest request) {
        BrandResponse brand = brandService.createBrand(request);
        APIResponse<BrandResponse> response = APIResponse.<BrandResponse>builder()
                .status(HttpStatus.CREATED.value())
                .message("Brand created successfully")
                .data(brand)
                .build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<BrandResponse>> updateBrand(
            @PathVariable Long id,
            @RequestBody @Valid BrandRequest request) {
        BrandResponse brand = brandService.updateBrand(id, request);
        APIResponse<BrandResponse> response = APIResponse.<BrandResponse>builder()
                .status(HttpStatus.OK.value())
                .message("Brand updated successfully")
                .data(brand)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<BrandResponse>>> getAllBrands() {
        List<BrandResponse> brands = brandService.getAllBrands();
        APIResponse<List<BrandResponse>> response = APIResponse.<List<BrandResponse>>builder()
                .status(HttpStatus.OK.value())
                .message("Brands retrieved successfully")
                .data(brands)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<BrandResponse>> getBrandById(@PathVariable Long id) {
        BrandResponse brand = brandService.getBrandById(id);
        APIResponse<BrandResponse> response = APIResponse.<BrandResponse>builder()
                .status(HttpStatus.OK.value())
                .message("Brand retrieved successfully")
                .data(brand)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Void>> deleteBrand(@PathVariable Long id) {
        brandService.deleteBrand(id);
        APIResponse<Void> response = APIResponse.<Void>builder()
                .status(HttpStatus.OK.value())
                .message("Brand deleted successfully")
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
