package com.klef.jfsd.sdp.agricultureapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.klef.jfsd.sdp.agricultureapp.model.Customer;
import com.klef.jfsd.sdp.agricultureapp.service.CustomerService;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
   @Autowired
   private CustomerService customerService;
   
   @PostMapping("/add")
   public String add(@RequestBody Customer customer) {
	   customerService.saveCustomer(customer);
	   return "New Customer is added";
   }
   
   @GetMapping("/getAll")
   public List<Customer> getAllCustomers(){
	   return customerService.getAllCustomers();
	   }
   
   @PostMapping("/login")
   public Map<String, Object> checkCustomerLogin(@RequestParam String name, @RequestParam String password) {
       Customer customer = customerService.checkCustomerLogin(name, password);
       Map<String, Object> response = new HashMap<>();
       
       if (customer != null) {
           response.put("status", "success");
           response.put("message", "Login successful");
           response.put("customer", customer);
       } else {
           response.put("status", "fail");
           response.put("message", "Invalid credentials");
       }
       
       return response;
   }
   
   @GetMapping("/get/{id}")
   public Customer getCustomerById(@PathVariable Integer id) {
       return customerService.getCustomerById(id); // Add this service method for fetching customer by ID
   }
   
   @PutMapping("/update/{id}")
   public Map<String, Object> updateCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
       Map<String, Object> response = new HashMap<>();
       Customer updatedCustomer = customerService.updateCustomer(id, customer);

       if (updatedCustomer != null) {
           response.put("status", "success");
           response.put("message", "Customer updated successfully");
           response.put("customer", updatedCustomer);
       } else {
           response.put("status", "fail");
           response.put("message", "Customer not found");
       }

       return response;
   }
   
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<String> deleteCustomer(@PathVariable Integer id) {
       boolean isDeleted = customerService.deleteCustomer(id);
       if (isDeleted) {
           return ResponseEntity.ok("User deleted successfully.");
       } else {
           return ResponseEntity.status(404).body("User not found.");
       }
   }
   
   
}
