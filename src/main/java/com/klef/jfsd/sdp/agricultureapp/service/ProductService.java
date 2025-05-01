package com.klef.jfsd.sdp.agricultureapp.service;

import java.util.List;
import java.util.Optional;

import com.klef.jfsd.sdp.agricultureapp.model.Customer;
import com.klef.jfsd.sdp.agricultureapp.model.Product;

public interface ProductService {

	
    Product saveProduct(Product product);

	 public List<Product> getAllProduct();
	 public Product getProductById(Integer id);
	 public Product updateProduct(Integer id, Product product);
}