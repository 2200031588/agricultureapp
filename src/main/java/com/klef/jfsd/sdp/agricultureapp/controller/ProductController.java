package com.klef.jfsd.sdp.agricultureapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klef.jfsd.sdp.agricultureapp.model.Customer;
import com.klef.jfsd.sdp.agricultureapp.model.Product;
import com.klef.jfsd.sdp.agricultureapp.service.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {
	@Autowired
    private ProductService productService;

	

    @PostMapping("/add")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.saveProduct(product);
        return ResponseEntity.ok(createdProduct);
    }

    @GetMapping("/getAll")
    public List<Product> getAllProduct(){
 	   return productService.getAllProduct();
 	   }

    @GetMapping("/get/{id}")
    public Product getCustomerById(@PathVariable Integer id) {
        return productService.getProductById(id); // Add this service method for fetching customer by ID
    }
    
    @PutMapping("/update/{id}")
    public Map<String, Object> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        Map<String, Object> response = new HashMap<>();
        Product updatedProduct = productService.updateProduct(id, product);

        if (updatedProduct != null) {
            response.put("status", "success");
            response.put("message", "Customer updated successfully");
            response.put("customer", updatedProduct);
        } else {
            response.put("status", "fail");
            response.put("message", "Customer not found");
        }

        return response;
    }
}
