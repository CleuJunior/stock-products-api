package com.csj.pdr.api.dto;

import com.csj.pdr.api.domain.Type;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CategoryResponse(String id,
                               String name,
                               boolean active,
                               Type type) {
}
