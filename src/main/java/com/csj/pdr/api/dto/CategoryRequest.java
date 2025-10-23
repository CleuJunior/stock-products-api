package com.csj.pdr.api.dto;

import com.csj.pdr.api.domain.Type;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CategoryRequest(String name, Boolean active, Type type) {
}
