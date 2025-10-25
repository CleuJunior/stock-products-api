package com.csj.pdr.api.build;

import com.csj.pdr.api.domain.Category;
import com.csj.pdr.api.domain.Type;
import com.csj.pdr.api.dto.CategoryRequest;
import com.csj.pdr.api.dto.CategoryResponse;

import java.util.UUID;

public final class CategoryBuild {

    private final static UUID ID = UUID.randomUUID();
    private final static String NAME = "Beverage";
    private final static boolean ACTIVE = true;
    private final static Type TYPE = Type.CUSTOM;

    private CategoryBuild() {
        throw new RuntimeException();
    }

    public static Category buildCategory() {
        return new Category(ID, NAME, ACTIVE, TYPE);
    }

    public static CategoryResponse buildCategoryResponse() {
        return new CategoryResponse(ID.toString(), NAME, ACTIVE, TYPE);
    }

    public static CategoryRequest buildCategoryRequest() {
        return new CategoryRequest(NAME, ACTIVE, TYPE);
    }
}
