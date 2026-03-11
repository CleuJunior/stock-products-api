package com.csj.pdr.api.repository;

import com.csj.pdr.api.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Override
    @Query("""
            SELECT p FROM products p
            LEFT JOIN FETCH p.category
            WHERE p.deleted IS FALSE AND p.id = :id
            """)
    Optional<Product> findById(@Param("id") UUID id);

    @Override
    @Query("""
            SELECT p FROM products p
            LEFT JOIN FETCH p.category
            WHERE p.deleted IS FALSE
            """)
    List<Product> findAll();

    @Query("""
            SELECT p FROM products p
            LEFT JOIN FETCH p.category
            WHERE p.deleted IS FALSE
            AND p.id IN :ids
            """)
    Set<Product> findAllById(@Param("ids") Set<UUID> ids);
}
