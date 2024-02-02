package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.Product;
import com.rest.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	@PostMapping("/save")
	public String save(@RequestBody  Product product) {
		Product p=productService.saveProduct(product);
		String message=null;
		if(p!=null) {
			message="Product Saved Successfully";
		}
		else {
			message="Product Not Saved.....!Please Try Again";
		}
		return message;
	}
	@GetMapping("/get/{pid}")
	public Product getProduct(@PathVariable int pid) {
		Product get1=productService.getOneProduct(pid);
		return get1;
	}
	@GetMapping("/getAll")
	public List<Product> getAll(){
		List<Product>getAll=productService.getAllProducts();
		return getAll;
	}
	@DeleteMapping("delete/{pid}")
	public void deleteProduct(@PathVariable int pid) {
		productService.deleteProduct(pid);
	}
	@PutMapping("update/{pid}")
	public Product updateProduct(@RequestBody Product product,@PathVariable int pid) {
		Product update=productService.updateProduct(product,pid);
		return update;
	}
}
