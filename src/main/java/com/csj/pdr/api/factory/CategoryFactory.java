package com.csj.pdr.api.factory;

import com.csj.pdr.api.domain.Category;
import com.csj.pdr.api.domain.Product;
import com.csj.pdr.api.dto.CategoryRequest;
import com.csj.pdr.api.dto.CategoryResponse;
import com.csj.pdr.api.repository.ProductRepository;
import com.csj.pdr.api.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CategoryFactory {

    private final IProductService productService;
    private final ProductRepository productRepository;

    public Category toCategory(CategoryRequest request) {
        return new Category(
                request.name(),
                request.active(),
                request.type(),
                products(request.productsId())
        );
    }

    private Set<Product> products(Set<String> ids) {
        var uuids = ids.stream()
                .map(UUID::fromString)
                .collect(Collectors.toSet());

        return productRepository.findAllById(uuids);
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
