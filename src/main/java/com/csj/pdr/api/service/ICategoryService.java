package com.csj.pdr.api.service;

import com.csj.pdr.api.domain.Category;
import com.csj.pdr.api.dto.CategoryRequest;

import java.util.List;

public interface ICategoryService {

    List<Category> getListCategories();

    Category getCategoryById(String id);

    Category saveCategory(CategoryRequest request);

    Category updateCategory(String id, CategoryRequest request);

    void deleteCategory(String id);

    void deleteBatchCategories(List<String> ids);
}
