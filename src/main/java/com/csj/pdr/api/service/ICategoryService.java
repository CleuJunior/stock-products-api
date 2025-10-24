package com.csj.pdr.api.service;

import com.csj.pdr.api.dto.CategoryRequest;
import com.csj.pdr.api.dto.CategoryResponse;

import java.util.List;

public interface ICategoryService {

    List<CategoryResponse> getListCategories();

    CategoryResponse getCategoryById(String id);

    CategoryResponse saveCategory(CategoryRequest request);

    CategoryResponse updateCategory(String id, CategoryRequest request);

    void deleteCategory(String id);

    void deleteBatchCategories(List<String> ids);
}
