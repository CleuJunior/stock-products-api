package com.csj.pdr.api.service;

import com.csj.pdr.api.dto.CategoryRequest;
import com.csj.pdr.api.dto.CategoryResponse;

import java.util.List;
import java.util.UUID;

public interface ICategoryService {

    List<CategoryResponse> getListCategories();
    CategoryResponse getById(String id);
    CategoryResponse saveCategory(CategoryRequest request);
    CategoryResponse updateCategory(String id, CategoryRequest request);
}
