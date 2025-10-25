package com.csj.pdr.api.dto;

import com.csj.pdr.api.domain.Product;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProductResponse(String id,
                              String name,
                              boolean active,
                              String sku,
                              List<CategoryResponse> categories,
                              double costValue,
                              int icms,
                              double saleValue,
                              String img,
                              LocalDate registrationDate,
                              int stock) {

    public static ProductResponse of(Product entity) {
        List<CategoryResponse> categories = entity.getCategories()
                .stream()
                .map(CategoryResponse::of)
                .toList();

        return new ProductResponse(
                entity.getId().toString(),
                entity.getName(),
                entity.isActive(),
                entity.getSku(),
                categories,
                entity.getCostValue(),
                entity.getIcms(), entity.getSaleValue(),
                entity.getImg(),
                entity.getRegistrationDate(),
                entity.getStock()
        );
    }
}
