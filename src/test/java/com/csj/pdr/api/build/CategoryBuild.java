package com.csj.pdr.api.build;

import com.csj.pdr.api.domain.Category;
import com.csj.pdr.api.domain.Type;
import com.csj.pdr.api.dto.CategoryRequest;
import com.csj.pdr.api.dto.CategoryResponse;

import java.time.OffsetDateTime;
import java.util.UUID;

public final class CategoryBuild {

    private final static UUID ID = UUID.randomUUID();
    private final static String NAME = "Beverage";
    private final static boolean ACTIVE = true;
    private final static Type TYPE = Type.CUSTOM;
    private final static OffsetDateTime CREATION_DATE = OffsetDateTime.now();
    private final static OffsetDateTime UPDATE_DATE = OffsetDateTime.now();

    private CategoryBuild() {
        throw new RuntimeException();
    }

    public static Category buildCategory() {
        var category = new Category();

        category.setId(ID);
        category.setName(NAME);
        category.setActive(ACTIVE);
        category.setType(TYPE);

        return category;
    }

    public static CategoryResponse buildCategoryResponse() {
        return new CategoryResponse(
                ID.toString(),
                NAME,
                ACTIVE,
                TYPE,
                CREATION_DATE,
                UPDATE_DATE,
                false
        );
    }

    public static CategoryRequest buildCategoryRequest() {
        return new CategoryRequest(NAME, ACTIVE, TYPE);
    }
}
