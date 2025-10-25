package com.csj.pdr.api.service;

import com.csj.pdr.api.dto.ProductRequest;
import com.csj.pdr.api.dto.ProductResponse;

import java.util.List;

public interface IProductService {

    List<ProductResponse> getListProducts();

    ProductResponse getProductById(String id);

    ProductResponse saveProduct(ProductRequest request);

    ProductResponse updateProduct(String id, ProductRequest request);

    void deleteProduct(String id);

    void deleteBatchProducts(List<String> ids);
}
