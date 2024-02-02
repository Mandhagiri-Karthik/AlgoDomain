package com.rest.service;

import java.util.List;

import com.rest.model.Product;

public interface ProductService {
	public Product saveProduct(Product product);
	public Product updateProduct(Product product, int pid);
	public void deleteProduct(int pid);
	public Product getOneProduct(int pid);
	public List<Product> getAllProducts();
	
}
