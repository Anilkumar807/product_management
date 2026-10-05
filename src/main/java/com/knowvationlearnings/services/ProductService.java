package com.knowvationlearnings.services;

import com.knowvationlearnings.entities.Product;

import java.util.List;

public interface ProductService {
    Product  addProduct(Product product);
    Product getProductById(Integer productId);
    List<Product> getAllProducts();
    Product updateProduct(Product product);
    Product deleteProductById(Integer productId);

}
