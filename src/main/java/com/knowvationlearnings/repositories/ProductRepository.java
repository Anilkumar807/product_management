package com.knowvationlearnings.repositories;

import com.knowvationlearnings.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductRepository extends JpaRepository<Product,Integer> {

}
