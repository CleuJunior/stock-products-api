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
    public Product updateProduct(String id, ProductRequest request) {
        var productToUpdate = findById(id);

        Optional.ofNullable(request.name())
                .ifPresent(productToUpdate::setName);
        Optional.ofNullable(request.active())
                .ifPresent(productToUpdate::setActive);
        Optional.ofNullable(request.sku())
                .ifPresent(productToUpdate::setSku);
        Optional.ofNullable(request.costValue())
                .ifPresent(productToUpdate::setCostValue);
        Optional.ofNullable(request.icms())
                .ifPresent(productToUpdate::setIcms);
        Optional.ofNullable(request.saleValue())
                .ifPresent(productToUpdate::setSaleValue);
        Optional.ofNullable(request.img())
                .ifPresent(productToUpdate::setImg);
        Optional.ofNullable(request.stock())
                .ifPresent(productToUpdate::setStock);
        Optional.ofNullable(request.category())
                .ifPresent(categories -> productToUpdate.setCategory(findCategory(categories)));

       return repository.save(productToUpdate);
    }

    private Product findById(String id) {
        return repository.findById(UUID.fromString(id))
                .orElseThrow();
    }

    private Category findCategory(String categoryId) {
        var uuid = UUID.fromString(categoryId);

        return categoryRepository.findById(uuid).orElseThrow();
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
