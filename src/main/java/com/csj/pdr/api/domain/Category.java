package com.csj.pdr.api.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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

    public Category(String id) {
        super.setId(UUID.fromString(id));
    }
}
