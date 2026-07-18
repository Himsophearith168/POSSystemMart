package com.example.PosSystemMart.Service.Impl;

import com.example.PosSystemMart.DTO.CategoryRequest;
import com.example.PosSystemMart.DTO.CategoryResponse;
import com.example.PosSystemMart.Mapper.CategoryMapper;
import com.example.PosSystemMart.Model.CategoryModel;
import com.example.PosSystemMart.Repository.CategoryRepository;
import com.example.PosSystemMart.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServicelmpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServicelmpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryResponse createCategory(CategoryRequest request){
        if (categoryRepository.existsByCategoryName(request.getCategoryName())) {
            throw new IllegalArgumentException("Category with name " + request.getCategoryName() + " already exists.");
        }
        CategoryModel category = CategoryMapper.toEntity(request);
        categoryRepository.save(category);
        return CategoryMapper.toResponse(category);
    }

    @Override
    public CategoryResponse updateCategory(Long id, CategoryRequest request){
        CategoryModel existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category with id " + id + " does not exist."));
        
        if (!existingCategory.getCategoryName().equalsIgnoreCase(request.getCategoryName()) && 
            categoryRepository.existsByCategoryName(request.getCategoryName())) {
            throw new IllegalArgumentException("Category with name " + request.getCategoryName() + " already exists.");
        }
        
        existingCategory.setCategoryName(request.getCategoryName());
        existingCategory.setCategoryDescription(request.getCategoryDescription());
        categoryRepository.save(existingCategory);
        return CategoryMapper.toResponse(existingCategory);
    }

    @Override
    public List<CategoryResponse> getAllCategory(){
        List<CategoryModel> categoryList = categoryRepository.findAll();
        return categoryList.stream()
                .map(CategoryMapper::toResponse)
                .toList();
    }

    @Override
    public CategoryResponse getCategoryByID (Long id){
        CategoryModel category = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category with id " + id + " does not exist."));
        return CategoryMapper.toResponse(category);
    }

    @Override
    public CategoryResponse deleteCategory(Long id){
        CategoryModel category = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category with id " + id + " does not exist."));
        categoryRepository.delete(category);
        return null;
    }
}
