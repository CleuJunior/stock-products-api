package com.csj.pdr.api.controller;

import com.csj.pdr.api.dto.ProductRequest;
import com.csj.pdr.api.dto.ProductResponse;
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

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getProductById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> listProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getListProducts());
    }

    @PostMapping
    public ResponseEntity<ProductResponse> saveProduct(@RequestBody ProductRequest request) {
        ProductResponse response = service.saveProduct(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable String id, @RequestBody ProductRequest request) {
        ProductResponse response = service.updateProduct(id, request);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        service.deleteProduct(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/batch")
    public ResponseEntity<Void> deleteBatchProducts(@RequestParam(required = false) List<String> ids) {
        service.deleteBatchProducts(ids);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
