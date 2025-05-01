package com.klef.jfsd.sdp.agricultureapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.sdp.agricultureapp.model.Customer;
import com.klef.jfsd.sdp.agricultureapp.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
