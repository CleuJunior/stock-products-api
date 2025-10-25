package com.csj.pdr.api.factory;

import com.csj.pdr.api.build.ProductBuild;
import com.csj.pdr.api.domain.Category;
import com.csj.pdr.api.domain.Product;
import com.csj.pdr.api.dto.ProductRequest;
import com.csj.pdr.api.dto.ProductResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class ProductFactoryTest {

    @InjectMocks
    private ProductFactory underTest;

    @Test
    void shouldMapProductRequestToProduct() {
        Category category = mock(Category.class);
        ProductRequest request = ProductBuild.buildProductRequest();

        Product result = underTest.toProduct(request, singletonList(category));

        then(result).isNotNull();
        then(result.getName()).isEqualTo(request.name());
        then(result.isActive()).isEqualTo(request.active());
        then(result.getSku()).isEqualTo(request.sku());
        then(result.getCostValue()).isEqualTo(request.costValue());
        then(result.getCategories()).isEqualTo(singletonList(category));
        then(result.getIcms()).isEqualTo(request.icms());
        then(result.getSaleValue()).isEqualTo(request.saleValue());
        then(result.getImg()).isEqualTo(request.img());
        then(result.getStock()).isEqualTo(request.stock());
    }

    @Test
    void shouldMapProductToProductResponse() {
        Product entity = ProductBuild.buildProduct();

        ProductResponse result = underTest.toProductResponse(entity);

        then(result).isNotNull();
        then(result.name()).isEqualTo(entity.getName());
        then(result.active()).isEqualTo(entity.isActive());
        then(result.sku()).isEqualTo(entity.getSku());
        then(result.costValue()).isEqualTo(entity.getCostValue());
        then(result.categories().get(0).id()).isEqualTo(entity.getCategories().get(0).getId().toString());
        then(result.icms()).isEqualTo(entity.getIcms());
        then(result.saleValue()).isEqualTo(entity.getSaleValue());
        then(result.img()).isEqualTo(entity.getImg());
        then(result.stock()).isEqualTo(entity.getStock());
    }

    @Test
    void shouldMapProductListToProductResponseList() {
        Product entity = ProductBuild.buildProduct();

        List<ProductResponse> result = underTest.toProductsResponse(singletonList(entity));

        then(result.size()).isEqualTo(1);
    }
}