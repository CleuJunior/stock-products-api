package com.csj.pdr.api.service;

import com.csj.pdr.api.domain.Category;
import com.csj.pdr.api.domain.Product;
import com.csj.pdr.api.dto.CategoryRequest;
import com.csj.pdr.api.dto.CategoryResponse;
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
    private final ProductFactory factory;

    @Override
    public List<ProductResponse> getListProducts() {
        List<Product> products = repository.findAll();

        return factory.toProductsResponse(products);
    }

    @Override
    public ProductResponse getProductById(String id) {
        Product product = findById(id);

        return factory.toProductResponse(product);
    }

    @Override
    public ProductResponse saveProduct(ProductRequest request) {
        List<Category> categories = findCategories(request.categories());
        Product entity = factory.toProduct(request, categories);

        repository.save(entity);

        return factory.toProductResponse(entity);
    }

    @Override
    public ProductResponse updateProduct(String id, ProductRequest request) {
        Product productToUpdate = findById(id);

        Optional.ofNullable(request.name()).ifPresent(productToUpdate::setName);
        Optional.ofNullable(request.active()).ifPresent(productToUpdate::setActive);
        Optional.ofNullable(request.sku()).ifPresent(productToUpdate::setSku);
        Optional.ofNullable(request.costValue()).ifPresent(productToUpdate::setCostValue);
        Optional.ofNullable(request.icms()).ifPresent(productToUpdate::setIcms);
        Optional.ofNullable(request.saleValue()).ifPresent(productToUpdate::setSaleValue);
        Optional.ofNullable(request.img()).ifPresent(productToUpdate::setImg);
        Optional.ofNullable(request.stock()).ifPresent(productToUpdate::setStock);

        Optional.ofNullable(request.categories())
                .filter(categories -> !categories.isEmpty())
                .ifPresent(categories -> {
                    List<Category> foundCategories = findCategories(categories);

                    productToUpdate.addCategory(foundCategories);
                });

        repository.save(productToUpdate);

        return factory.toProductResponse(productToUpdate);
    }

    private Product findById(String id) {
        return repository.findById(UUID.fromString(id))
                .orElseThrow();
    }

    private List<Category> findCategories(List<String> categoriesId) {
        List<UUID> uuids = categoriesId.stream()
                .map(UUID::fromString)
                .toList();

        return categoryRepository.findAllById(uuids);
    }

    @Override
    public void deleteProduct(String id) {
        Product productToDelete = Product.of(id);

        repository.delete(productToDelete);
    }

    @Override
    public void deleteBatchProducts(List<String> ids) {
        if (ids.isEmpty()) {
            return;
        }

        List<Product> productsToDelete = ids.stream()
                .filter(Objects::nonNull)
                .map(Product::of)
                .toList();

        repository.deleteAllInBatch(productsToDelete);
    }
}
