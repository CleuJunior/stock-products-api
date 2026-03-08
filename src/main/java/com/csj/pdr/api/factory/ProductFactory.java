package com.csj.pdr.api.factory;

import com.csj.pdr.api.domain.Category;
import com.csj.pdr.api.domain.Product;
import com.csj.pdr.api.dto.ProductRequest;
import com.csj.pdr.api.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductFactory {

    private final CategoryFactory categoryFactory;

    public Product toProduct(ProductRequest request, Category category) {
        var product = new Product();

        product.setName(request.name());
        product.setActive(request.active());
        product.setSku(request.sku());
        product.setCostValue(request.costValue());
        product.setCategory(category);
        product.setIcms(request.icms());
        product.setSaleValue(request.saleValue());
        product.setImg(request.img());
        product.setStock(request.stock());

        return product;
    }

    public ProductResponse toProductResponse(Product entity) {
        var categories = entity.getCategory();
        var categoryResponse = categoryFactory.toCategoryResponse(categories);

        return new ProductResponse(
                entity.getId(),
                entity.getName(),
                entity.isActive(),
                entity.getSku(),
                categoryResponse,
                entity.getCostValue(),
                entity.getIcms(),
                entity.getSaleValue(),
                entity.getImg(),
                entity.getRegistrationDate(),
                entity.getStock()
        );
    }

    public List<ProductResponse> toProductsResponse(List<Product> products) {
        return products.stream()
                .map(this::toProductResponse)
                .toList();
    }
}
