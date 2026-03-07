package com.csj.pdr.api.repository;

import com.csj.pdr.api.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

    @Override
    @Query("""
                SELECT c FROM categories c
                LEFT JOIN FETCH c.products
                WHERE c.deleted IS FALSE AND c.id = :id
            """)
    Optional<Category> findById(@Param("id") UUID id);

    @Override
    @Query("""
                SELECT c FROM categories c
                LEFT JOIN FETCH c.products
                WHERE c.deleted IS FALSE
            """)
    List<Category> findAll();

    @Query("SELECT COUNT(c.id) FROM categories c WHERE c.deleted IS FALSE")
    long count();
}
