package com.knowvationlearnings.services;

import com.knowvationlearnings.entities.Product;
import com.knowvationlearnings.exceptions.ProductNotFoundException;
import com.knowvationlearnings.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImple implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
    @Override
    public Product getProductById(Integer productId) {

        return productRepository.findById(productId)
                .orElseThrow(() ->
                        new ProductNotFoundException(
                                "Invalid Product ID " + productId
                        ));
    }
    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        if (productList.isEmpty()) {
            throw new ProductNotFoundException(
                    "No Product found"
            );
        }
        return productList;
    }
    @Override
    public Product updateProduct(Product product) {
        getProductById(product.getProductId());
        return productRepository.save(product);
    }
    @Override
    public Product deleteProductById(Integer productId) {
        Product product = getProductById(productId);
        productRepository.deleteById(productId);
        return product;
    }
}