package com.csj.pdr.api.factory;

import com.csj.pdr.api.domain.Category;
import com.csj.pdr.api.domain.Product;
import com.csj.pdr.api.dto.CategoryResponse;
import com.csj.pdr.api.dto.ProductRequest;
import com.csj.pdr.api.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductFactory {

    private final CategoryFactory categoryFactory;

    public Product toProduct(ProductRequest request, List<Category> categories) {
        var product = new Product();

        product.setName(request.name());
        product.setActive(request.active());
        product.setSku(request.sku());
        product.setCostValue(request.costValue());
        product.addCategory(categories);
        product.setIcms(request.icms());
        product.setSaleValue(request.saleValue());
        product.setImg(request.img());
        product.setStock(request.stock());

        return product;
    }

    public ProductResponse toProductResponse(Product entity) {
        var categories = entity.getCategories();
        var categoryResponses = categoryFactory.toCategoryResponse(categories);

        return new ProductResponse(
                entity.getId().toString(),
                entity.getName(),
                entity.isActive(),
                entity.getSku(),
                categoryResponses,
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
