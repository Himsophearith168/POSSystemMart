package com.example.PosSystemMart.Controller;

import com.example.PosSystemMart.DTO.CategoryRequest;
import com.example.PosSystemMart.DTO.CategoryResponse;
import com.example.PosSystemMart.Service.CategoryService;
import com.example.PosSystemMart.Util.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categories")
@CrossOrigin(origins = "*")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<APIResponse<CategoryResponse>> createCategory(@RequestBody CategoryRequest request){
        CategoryResponse categoryResponse = categoryService.createCategory(request);
        APIResponse<CategoryResponse> apiResponse = APIResponse.<CategoryResponse>builder()
                .status(HttpStatus.CREATED.value())
                .message("You Create a new Category Successfully")
                .data(categoryResponse)
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<APIResponse<List<CategoryResponse>>> getAllCategory(){
        List<CategoryResponse> categoryList = categoryService.getAllCategory();
        APIResponse<List<CategoryResponse>> response = APIResponse.<List<CategoryResponse>>builder()
                .status(HttpStatus.OK.value())
                .message("You Retriev Category Successfully")
                .data(categoryList)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
