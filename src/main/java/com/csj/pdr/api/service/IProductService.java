package com.csj.pdr.api.service;

import com.csj.pdr.api.domain.Product;

import java.util.List;

public interface IProductService {

    List<Product> getListProducts();

    Product getProductById(String id);

    Product saveProduct(Product request);

    Product updateProduct(String id, Product request);

    void softDeleteProduct(String id);

    void softDeleteBatchProducts(List<String> ids);
}
