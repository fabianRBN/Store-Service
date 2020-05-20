package com.aliance.store.store.service;

import com.aliance.store.store.entity.Category;
import com.aliance.store.store.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> listAllProducts();
    public Product getProduct(Long id);
    public Product createProduct(Product product);
    public Product updateProduct(Product product);
    public Product deleteProduct(Long id);
    public List<Product> findByCategory(Category category);
    public Product updateStock(Long id, Double quantity);
}
