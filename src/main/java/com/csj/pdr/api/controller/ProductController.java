package com.csj.pdr.api.controller;

import com.csj.pdr.api.dto.ProductRequest;
import com.csj.pdr.api.dto.ProductResponse;
import com.csj.pdr.api.factory.ProductFactory;
import com.csj.pdr.api.service.ICategoryService;
import com.csj.pdr.api.service.IProductService;
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
@RequestMapping(value = "/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService service;
    private final ICategoryService categoryService;
    private final ProductFactory factory;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable String id) {
        var product = service.getProductById(id);
        var response = factory.toProductResponse(product);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> listProducts() {
        var products = service.getListProducts();
        var response = factory.toProductsResponse(products);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<ProductResponse> saveProduct(@RequestBody ProductRequest request) {
        var category = categoryService.getCategoryById(request.category());
        var product = factory.toProduct(request, category);
        var savedProduct = service.saveProduct(product);
        var response = factory.toProductResponse(savedProduct);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

//    @PutMapping(value = "/{id}")
//    public ResponseEntity<ProductResponse> updateProduct(@PathVariable String id, @RequestBody ProductRequest request) {
//        ProductResponse response = service.updateProduct(id, request);
//
//        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
//    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        service.softDeleteProduct(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/batch")
    public ResponseEntity<Void> deleteBatchProducts(@RequestParam(required = false) List<String> ids) {
        service.softDeleteBatchProducts(ids);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
