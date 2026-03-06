package com.csj.pdr.api.factory;

import com.csj.pdr.api.build.CategoryBuild;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.assertj.core.api.BDDAssertions.then;

@ExtendWith(MockitoExtension.class)
class CategoryFactoryTest {

    @InjectMocks
    private CategoryFactory underTest;

    @Test
    void shouldMapCategoryRequestToCategory() {
        var request = CategoryBuild.buildCategoryRequest();

        var result = underTest.toCategory(request);

        then(result).isNotNull();
        then(result.getName()).isEqualTo(request.name());
        then(result.isActive()).isEqualTo(request.active());
        then(result.getType()).isEqualTo(request.type());
    }

    @Test
    void shouldMapCategoryToCategoryResponse() {
        var category = CategoryBuild.buildCategory();

        var result = underTest.toCategoryResponse(category);

        then(result).isNotNull();
        then(result.id()).isEqualTo(category.getId().toString());
        then(result.name()).isEqualTo(category.getName());
        then(result.active()).isEqualTo(category.isActive());
        then(result.type()).isEqualTo(category.getType());
    }

    @Test
    void shouldMapCategoriesToCategoriesResponse() {
        var category = CategoryBuild.buildCategory();

        var result = underTest.toCategoryResponse(Collections.singletonList(category));

        then(result.size()).isEqualTo(1);
        then(result.get(0).id()).isEqualTo(category.getId());
        then(result.get(0).name()).isEqualTo(category.getName());
        then(result.get(0).active()).isEqualTo(category.isActive());
        then(result.get(0).type()).isEqualTo(category.getType());
    }
}