package com.csj.pdr.api.service;

import com.csj.pdr.api.domain.Category;
import com.csj.pdr.api.factory.CategoryFactory;
import com.csj.pdr.api.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {

    @Mock
    private CategoryRepository repository;
    @Spy
    private CategoryFactory factory;
    @Mock
    private Category entity;
    @InjectMocks
    private CategoryServiceImpl underTest;

    @Test
    void shouldGetListCategoriesResponse() {
//        given(repository.findAll()).willReturn(singletonList(entity));
//
//        var result = underTest.getListCategories();
//
//        then(result.size()).isEqualTo(1);
//        then(result.get(0).id()).isEqualTo(entity.getId());
//        then(result.get(0).name()).isEqualTo(entity.getName());
//        then(result.get(0).active()).isEqualTo(entity.isActive());
//        then(result.get(0).type()).isEqualTo(entity.getType());
//
//        verify(repository).findAll();
//        verify(factory).toCategoryResponse(singletonList(entity));
    }

    @Test
    void getCategoryById() {
    }

    @Test
    void saveCategory() {
    }

    @Test
    void updateCategory() {
    }

    @Test
    void deleteCategory() {
    }

    @Test
    void deleteBatchCategories() {
    }
}