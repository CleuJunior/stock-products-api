package com.csj.pdr.api.service;

import com.csj.pdr.api.domain.Category;
import com.csj.pdr.api.dto.CategoryRequest;
import com.csj.pdr.api.dto.CategoryResponse;
import com.csj.pdr.api.factory.CategoryFactory;
import com.csj.pdr.api.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {

    private final CategoryRepository repository;
    private final CategoryFactory factory;

    @Override
    public List<CategoryResponse> getListCategories() {
        List<Category> categories = repository.findAll();

        return factory.toCategoryResponse(categories);
    }

    @Override
    public CategoryResponse getCategoryById(String id) {
        Category category = findById(id);

        return factory.toCategoryResponse(category);
    }

    @Override
    public CategoryResponse saveCategory(CategoryRequest request) {
        Category category = factory.toCategory(request);

        repository.save(category);

        return factory.toCategoryResponse(category);
    }

    @Override
    public CategoryResponse updateCategory(String id, CategoryRequest request) {
        Category category = findById(id);

        Optional.ofNullable(request.name()).ifPresent(category::setName);
        Optional.ofNullable(request.active()).ifPresent(category::setActive);
        Optional.ofNullable(request.type()).ifPresent(category::setType);

        repository.save(category);

        return factory.toCategoryResponse(category);
    }

    private Category findById(String id) {
        return repository.findById(UUID.fromString(id))
                .orElseThrow();
    }

    @Override
    public void deleteCategory(String id) {
        Category categoryToDelete = Category.of(id);

        repository.delete(categoryToDelete);
    }

    @Override
    public void deleteBatchCategories(List<String> ids) {
        if (ids.isEmpty()) {
            return;
        }

        List<Category> categoriesToDelete = ids.stream()
                .filter(Objects::nonNull)
                .map(Category::of)
                .toList();

        repository.deleteAllInBatch(categoriesToDelete);
    }
}
