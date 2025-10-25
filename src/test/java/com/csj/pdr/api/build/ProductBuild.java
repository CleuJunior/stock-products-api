package com.csj.pdr.api.build;

import com.csj.pdr.api.domain.Category;
import com.csj.pdr.api.domain.Product;
import com.csj.pdr.api.dto.ProductRequest;
import com.csj.pdr.api.dto.ProductResponse;

import java.util.List;
import java.util.UUID;

public final class ProductBuild {

    private final static UUID ID = UUID.randomUUID();
    private final static String NAME = "Samsung Galaxy Book4";
    private final static boolean ACTIVE = true;
    private final static String SKU = "SAM-GB4-I5-16-512-S";
    private final static List<Category> CATEGORIES = List.of(CategoryBuild.buildCategory());
    private final static double COST_VALUE = 5.916;
    private final static int ICMS = 3;
    private final static double SALE_VALUE = 6.099;
    private final static String IMG = "link-img";
    private final static int STOCK = 8;

    private ProductBuild() {
        throw new RuntimeException();
    }

    public static Product buildProduct() {
        Product product = new Product();

        product.setId(ID);
        product.setName(NAME);
        product.setActive(ACTIVE);
        product.setSku(SKU);
        product.addCategory(CATEGORIES);
        product.setCostValue(COST_VALUE);
        product.setIcms(ICMS);
        product.setSaleValue(SALE_VALUE);
        product.setImg(IMG);
        product.setStock(STOCK);

        return product;
    }

    public static ProductResponse buildProductResponse() {
        return ProductResponse.of(buildProduct());
    }

    public static ProductRequest buildProductRequest() {
        List<String> categoriesId = CATEGORIES.stream()
                .map(cat -> cat.getId().toString())
                .toList();

        return new ProductRequest(
                NAME,
                ACTIVE,
                SKU,
                categoriesId,
                COST_VALUE,
                ICMS,
                SALE_VALUE, IMG,
                STOCK
        );
    }
}
