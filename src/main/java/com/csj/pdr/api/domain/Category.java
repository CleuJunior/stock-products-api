package com.csj.pdr.api.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static jakarta.persistence.EnumType.STRING;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Entity(name = "categories")
public class Category extends BaseEntity {

    private String name;
    private boolean active;
    @Enumerated(STRING)
    private Type type;
    @OneToMany(mappedBy = "category")
    @ToString.Exclude
    private Set<Product> products = new HashSet<>();

    public Category(String id) {
        super.id = UUID.fromString(id);
    }

    public void addProduct(Product product) {
        products.add(product);
        product.setCategory(this);
    }
}
