package com.csj.pdr.api.factory;

import com.csj.pdr.api.build.CategoryBuild;
import com.csj.pdr.api.domain.Category;
import com.csj.pdr.api.domain.Type;
import com.csj.pdr.api.dto.CategoryRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.BDDAssertions.then;

@ExtendWith(SpringExtension.class)
class CategoryFactoryTest {

    @InjectMocks
    private CategoryFactory underTest;

    @Test
    void shouldMapCategoryRequestToCategory() {
        CategoryRequest request = CategoryBuild.buildCategoryRequest();

        Category result = underTest.toCategory(request);

        String actualName = assertThat(result).extracting(Category::getName).actual();
        boolean actualActive = assertThat(result).extracting(Category::isActive).actual();
        Type actualType = assertThat(result).extracting(Category::getType).actual();

        then(result).isNotNull();
        then(result.getName()).isSameAs(actualName);
        then(result.isActive()).isSameAs(actualActive);
        then(result.getType()).isSameAs(actualType);
    }
}