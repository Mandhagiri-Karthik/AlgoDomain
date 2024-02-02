package com.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.model.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

}
