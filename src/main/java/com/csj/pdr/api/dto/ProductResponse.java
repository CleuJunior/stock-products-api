package com.csj.pdr.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProductResponse(
        String id,
        String name,
        boolean active,
        String sku,
        CategoryResponse category,
        double costValue,
        int icms,
        double saleValue,
        String img,
        LocalDate registrationDate,
        int stock)
{ }
