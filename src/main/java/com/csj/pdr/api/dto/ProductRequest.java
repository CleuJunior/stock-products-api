package com.csj.pdr.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ProductRequest(String name,
                             Boolean active,
                             String sku,
                             String category,
                             Double costValue,
                             Integer icms,
                             Double saleValue,
                             String img,
                             Integer stock) {
}
