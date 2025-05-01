package com.klef.jfsd.sdp.agricultureapp.service;

import java.util.List;

import com.klef.jfsd.sdp.agricultureapp.model.Customer;

public interface CustomerService {
	 public Customer saveCustomer(Customer customer);
	 public List<Customer> getAllCustomers();
	 Customer checkCustomerLogin(String name, String password);
	 public Customer getCustomerById(Integer id);
	 public Customer updateCustomer(Integer id, Customer customer);
	 boolean deleteCustomer(Integer id);
}
