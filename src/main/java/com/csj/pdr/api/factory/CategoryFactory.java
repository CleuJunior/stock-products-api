package com.csj.pdr.api.factory;

import com.csj.pdr.api.domain.Category;
import com.csj.pdr.api.dto.CategoryRequest;
import com.csj.pdr.api.dto.CategoryResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryFactory {

    public Category toCategory(CategoryRequest request) {
        return new Category(request.name(), request.active(), request.type());
    }

    public CategoryResponse toCategoryResponse(Category entity) {
        return new CategoryResponse(
                entity.getId(),
                entity.getName(),
                entity.isActive(),
                entity.getType(),
                entity.getCreationDate(),
                entity.getUpdateDate(),
                entity.isDeleted()
        );
    }

    public List<CategoryResponse> toCategoryResponse(List<Category> categories) {
        return categories.stream()
                .map(this::toCategoryResponse)
                .toList();
    }
}
