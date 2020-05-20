package com.aliance.store.store.repository;

import com.aliance.store.store.entity.Category;
import com.aliance.store.store.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    public List<Product> findByCategory(Category category);
}
