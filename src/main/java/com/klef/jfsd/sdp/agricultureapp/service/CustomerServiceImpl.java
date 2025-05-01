package com.klef.jfsd.sdp.agricultureapp.service;

import com.klef.jfsd.sdp.agricultureapp.model.Customer;
import com.klef.jfsd.sdp.agricultureapp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

   
    @Override
    public Customer checkCustomerLogin(String name, String password) {
        return customerRepository.findByNameAndPassword(name, password);
    }

	@Override
	public Customer getCustomerById(Integer id) {
		 Optional<Customer> customer = customerRepository.findById(id);
	        return customer.orElse(null);
	}

	 @Override
	    public Customer updateCustomer(Integer id, Customer customer) {
	        Optional<Customer> existingCustomerOpt = customerRepository.findById(id);
	        if (existingCustomerOpt.isPresent()) {
	            Customer existingCustomer = existingCustomerOpt.get();
	            existingCustomer.setName(customer.getName());
	            existingCustomer.setAddress(customer.getAddress());
	            existingCustomer.setContact(customer.getContact());
	            return customerRepository.save(existingCustomer); // Save updated customer
	        }
	        return null; // Return null if customer not found
	    }
	 
	 @Override
	    public boolean deleteCustomer(Integer id) {
	        // Check if the customer exists
	        if (customerRepository.existsById(id)) {
	            // Delete the customer if exists
	            customerRepository.deleteById(id);
	            return true;
	        } else {
	            return false;
	        }
	    }
}
