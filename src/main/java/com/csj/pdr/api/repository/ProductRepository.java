package com.csj.pdr.api.repository;

import com.csj.pdr.api.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

//    @Query("SELECT p FROM Product p WHERE p.deleted IS FALSE")
//    @Override
//    List<Product> findAll();
}
