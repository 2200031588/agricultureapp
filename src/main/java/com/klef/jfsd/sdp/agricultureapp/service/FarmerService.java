package com.klef.jfsd.sdp.agricultureapp.service;

import java.util.List;
import java.util.Optional;

import com.klef.jfsd.sdp.agricultureapp.model.Customer;
import com.klef.jfsd.sdp.agricultureapp.model.Farmer;

public interface FarmerService {
	public Farmer saveFarmer(Farmer farmer);
	 public List<Farmer> getAllFarmers();
	 Farmer checkFarmerLogin(String name, String password);
	 Farmer updateFarmer(int farmerId, Farmer farmer);
	 boolean deleteFarmerById(int id);
	 Optional<Farmer> getFarmerById(Integer id);
}
