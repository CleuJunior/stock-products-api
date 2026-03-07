package com.csj.pdr.api.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Entity(name = "products")
@Table(name = "products")
public class Product extends BaseEntity {

    private String name;
    private boolean active;
    private String sku;
    @ManyToOne
    @JoinTable(name = "category_id")
    @ToString.Exclude
    private Category category;
    private double costValue;
    private int icms;
    private double saleValue;
    private String img;
    private LocalDate registrationDate;
    private int stock;

    public Product(String id) {
        super.id = UUID.fromString(id);
    }
}
