package com.klef.jfsd.sdp.agricultureapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.sdp.agricultureapp.model.Customer;
import com.klef.jfsd.sdp.agricultureapp.model.Product;
import com.klef.jfsd.sdp.agricultureapp.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	  @Autowired
	    private ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	  @Override
	    public List<Product> getAllProduct() {
	        return productRepository.findAll();
	    }
	
	  @Override
		public Product getProductById(Integer id) {
			 Optional<Product> product = productRepository.findById(id);
		        return product.orElse(null);
		}
	  
	  @Override
	    public Product updateProduct(Integer id, Product product) {
	        Optional<Product> existingProductOpt = productRepository.findById(id);
	        if (existingProductOpt.isPresent()) {
	            Product existingProduct = existingProductOpt.get();
	            existingProduct.setProductname(product.getProductname());
	            existingProduct.setCategory(product.getCategory());
	            return productRepository.save(existingProduct); // Save updated customer
	        }
	        return null; // Return null if customer not found
	    }
}
