package com.klef.jfsd.sdp.agricultureapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

import com.klef.jfsd.sdp.agricultureapp.model.Customer;
import com.klef.jfsd.sdp.agricultureapp.model.Farmer;
import com.klef.jfsd.sdp.agricultureapp.service.FarmerService;

@RestController
@RequestMapping("/farmer")
@CrossOrigin
public class FarmerController {
	
	@Autowired
	private FarmerService farmerService;
	
	 
	   @PostMapping("/add")
	   public String add(@RequestBody Farmer farmer) {
		   farmerService.saveFarmer(farmer);
		   return "New Customer is added";
	   }
	   
	   @GetMapping("/getAll")
	   public List<Farmer> getAllFarmers(){
		   return farmerService.getAllFarmers();
		   }
	   
	   @PostMapping("/login")
	   public Map<String, Object> checkFarmerLogin(@RequestParam String name, @RequestParam String password) {
	       Farmer farmer = farmerService.checkFarmerLogin(name, password);
	       Map<String, Object> response = new HashMap<>();
	       
	       if (farmer != null) {
	           response.put("status", "success");
	           response.put("message", "Login successful");
	           response.put("customer", farmer);
	       } else {
	           response.put("status", "fail");
	           response.put("message", "Invalid credentials");
	       }
	       
	       return response;
	   }
	   
	   @PutMapping("/update/{farmerId}")
	    public ResponseEntity<Farmer> updateFarmer(@PathVariable("farmerId") int farmerId, @RequestBody Farmer farmer) {
	        try {
	            Farmer updatedFarmer = farmerService.updateFarmer(farmerId, farmer);
	            return new ResponseEntity<>(updatedFarmer, HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	        }
	    }
	   
	   @GetMapping("/{id}")
	    public ResponseEntity<Farmer> getFarmerById(@PathVariable Integer id) {
	        Optional<Farmer> farmer = farmerService.getFarmerById(id);
	        return farmer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	   @DeleteMapping("/delete/{id}")
	    public ResponseEntity<String> deleteFarmer(@PathVariable int id) {
	        boolean isDeleted = farmerService.deleteFarmerById(id);
	        if (isDeleted) {
	            return ResponseEntity.ok("Farmer deleted successfully.");
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Farmer not found.");
	        }
	    }
}
