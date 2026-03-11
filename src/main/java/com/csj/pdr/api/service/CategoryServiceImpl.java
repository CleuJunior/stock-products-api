package com.csj.pdr.api.service;

import com.csj.pdr.api.domain.Category;
import com.csj.pdr.api.dto.CategoryRequest;
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

    @Override
    public List<Category> getListCategories() {
        return repository.findAll();
    }

    @Override
    public Category getCategoryById(String id) {
        return findById(id);
    }

    @Override
    public Category saveCategory(CategoryRequest request) {
        return repository.save(new Category());
    }

    @Override
    public Category updateCategory(String id, CategoryRequest request) {
        Category category = findById(id);

        Optional.ofNullable(request.name()).ifPresent(category::setName);
        Optional.ofNullable(request.active()).ifPresent(category::setActive);
        Optional.ofNullable(request.type()).ifPresent(category::setType);

        return repository.save(category);
    }

    private Category findById(String id) {
        return repository.findById(UUID.fromString(id))
                .orElseThrow();
    }

    @Override
    public void deleteCategory(String id) {
        var categoryToDelete = new Category(id);

        repository.delete(categoryToDelete);
    }

    @Override
    public void deleteBatchCategories(List<String> ids) {
        if (ids.isEmpty()) {
            return;
        }

        var categoriesToDelete = ids.stream()
                .filter(Objects::nonNull)
                .map(Category::new)
                .toList();

        repository.deleteAllInBatch(categoriesToDelete);
    }
}
