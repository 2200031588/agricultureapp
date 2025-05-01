package com.klef.jfsd.sdp.agricultureapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.sdp.agricultureapp.model.Customer;
import com.klef.jfsd.sdp.agricultureapp.model.Farmer;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer, Integer> {
	
	Farmer findByNameAndPassword(String name, String password);
}
