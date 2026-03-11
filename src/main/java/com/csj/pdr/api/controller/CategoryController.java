package com.csj.pdr.api.controller;

import com.csj.pdr.api.dto.CategoryRequest;
import com.csj.pdr.api.dto.CategoryResponse;
import com.csj.pdr.api.factory.CategoryFactory;
import com.csj.pdr.api.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final ICategoryService service;
    private final CategoryFactory factory;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable String id) {
        var category = service.getCategoryById(id);
        var response = factory.toCategoryResponse(category);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> listOfCategories() {
        var categories = service.getListCategories();
        var response = factory.toCategoryResponse(categories);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> saveCategory(@RequestBody CategoryRequest request) {
        var categoryRequest = factory.toCategory(request);

        var categories = service.getListCategories();
        var response = factory.toCategoryResponse(categories);

        return null;
    }
//
//    @PutMapping(value = "/{id}")
//    public ResponseEntity<CategoryResponse> updateCategory(@PathVariable String id, @RequestBody CategoryRequest request) {
//        CategoryResponse response = service.updateCategory(id, request);
//
//        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
//    }
//
//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity<Void> deleteCategory(@PathVariable String id) {
//        service.deleteCategory(id);
//
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }
//
//    @DeleteMapping("/batch")
//    public ResponseEntity<Void> deleteBatchCategory(@RequestParam(required = false) List<String> ids) {
//        service.deleteBatchCategories(ids);
//
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }
}
