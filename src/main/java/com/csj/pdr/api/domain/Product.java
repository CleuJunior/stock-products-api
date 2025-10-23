package com.csj.pdr.api.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "products")
@AllArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;
    private String name;
    private boolean active;
    private String sku;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter(AccessLevel.NONE)
    private List<Category> categories = new ArrayList<>();
    private double costValue;
    private int icms;
    private double saleValue;
    private String img;
    private LocalDate registrationDate;
    private int stock;

    public Product() {
        this.registrationDate = LocalDate.now();
    }

    public Product(String name, boolean active, String sku, double costValue, List<Category> categories, int icms,
                   double saleValue, String img, int stock) {

        this.name = name;
        this.active = active;
        this.sku = sku;
        this.costValue = costValue;
        this.categories.addAll(categories);
        this.icms = icms;
        this.saleValue = saleValue;
        this.img = img;
        this.stock = stock;

        this.registrationDate = LocalDate.now();
    }

    public void addCategory(List<Category> categories) {
        if (categories.isEmpty()) {
            return;
        }

        this.categories.addAll(categories);
    }
}
