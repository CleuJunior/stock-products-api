package com.csj.pdr.api.service;

import com.csj.pdr.api.domain.Category;
import com.csj.pdr.api.domain.Product;
import com.csj.pdr.api.dto.ProductRequest;
import com.csj.pdr.api.dto.ProductResponse;
import com.csj.pdr.api.factory.ProductFactory;
import com.csj.pdr.api.repository.CategoryRepository;
import com.csj.pdr.api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final ProductRepository repository;
    private final CategoryRepository categoryRepository;

    @Override
    public List<Product> getListProducts() {
        return repository.findAll();
    }

    @Override
    public Product getProductById(String id) {
        return findById(id);
    }

    @Override
    public Product saveProduct(Product request) {
        return repository.save(request);
    }

    @Override
    public Product updateProduct(String id, Product request) {
        var productToUpdate = findById(id);

        productToUpdate.setName(request.getName());
        productToUpdate.setActive(request.isActive());
        productToUpdate.setSku(request.getSku());
        productToUpdate.setCostValue(request.getCostValue());
        productToUpdate.setIcms(request.getIcms());
        productToUpdate.setSaleValue(request.getSaleValue());
        productToUpdate.setImg(request.getImg());
        productToUpdate.setStock(request.getStock());
        productToUpdate.setCategory(request.getCategory());

       return repository.save(productToUpdate);
    }

    private Product findById(String id) {
        return repository.findById(UUID.fromString(id))
                .orElseThrow();
    }

    @Override
    public void softDeleteProduct(String id) {
        var productToDelete = new Product(id);
        productToDelete.setDeleted(true);

        repository.save(productToDelete);
    }

    @Override
    public void softDeleteBatchProducts(List<String> ids) {
        var productsToDelete = ids.stream()
                .filter(Objects::nonNull)
                .map(id -> {
                    var productToDelete = new Product(id);
                    productToDelete.setDeleted(true);

                    return productToDelete;
                })
                .toList();

        repository.saveAll(productsToDelete);
    }
}
