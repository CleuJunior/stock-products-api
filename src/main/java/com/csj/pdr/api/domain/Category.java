package com.csj.pdr.api.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "categories")
public class Category extends BaseEntity {

    private String name;
    private boolean active;
    @Enumerated(EnumType.STRING)
    private Type type;
}
