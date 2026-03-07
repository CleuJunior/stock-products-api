package com.csj.pdr.api.dto;

import com.csj.pdr.api.domain.Type;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CategoryRequest(String name, Boolean active, Type type, Set<String> productsId) {
}
