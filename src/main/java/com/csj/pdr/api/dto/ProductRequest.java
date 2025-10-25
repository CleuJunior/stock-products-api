package com.csj.pdr.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ProductRequest(String name,
                             Boolean active,
                             String sku,
                             List<String> categories,
                             Double costValue,
                             Integer icms,
                             Double saleValue,
                             String img,
                             Integer stock) {
}
