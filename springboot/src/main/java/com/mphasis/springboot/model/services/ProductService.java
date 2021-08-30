package com.mphasis.springboot.model.services;

import com.mphasis.springboot.model.entities.Product;

import java.util.List;

public interface ProductService {
    public Product createProduct(Product product);
    public List<Product> getAllProducts();
    public Product getProductById(int id);
    public Product updateProduct(Product product);
    public boolean deleteProduct(int id);
}
