package com.klef.jfsd.sdp.agricultureapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.sdp.agricultureapp.model.Customer;
import com.klef.jfsd.sdp.agricultureapp.model.Farmer;
import com.klef.jfsd.sdp.agricultureapp.repository.FarmerRepository;

@Service
public class FarmerServiceImpl implements FarmerService {

	@Autowired
	private FarmerRepository farmerRepository;
	
	@Override
	public Farmer saveFarmer(Farmer farmer) {
		return  farmerRepository.save(farmer);
	}

	@Override
	public List<Farmer> getAllFarmers() {
		return farmerRepository.findAll();
	}
	
	 @Override
	    public Optional<Farmer> getFarmerById(Integer id) {
	        return farmerRepository.findById(id);
	    }

	@Override
    public Farmer checkFarmerLogin(String name, String password) {
        return farmerRepository.findByNameAndPassword(name, password);
    }
	
	   @Override
	    public Farmer updateFarmer(int farmerId, Farmer farmer) {
	        // Check if farmer exists
	        Farmer existingFarmer = farmerRepository.findById(farmerId).orElseThrow(() -> new RuntimeException("Farmer not found"));
	        
	        // Update farmer fields
	        existingFarmer.setName(farmer.getName());
	        existingFarmer.setEmail(farmer.getEmail());
	        existingFarmer.setPassword(farmer.getPassword());
	        existingFarmer.setState(farmer.getState());
	        existingFarmer.setVillage(farmer.getVillage());
	        existingFarmer.setMobile(farmer.getMobile());
	        
	        // Save updated farmer
	        return farmerRepository.save(existingFarmer);
	    }

	   @Override
	    public boolean deleteFarmerById(int id) {
	        if (farmerRepository.existsById(id)) {
	            farmerRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }
}
