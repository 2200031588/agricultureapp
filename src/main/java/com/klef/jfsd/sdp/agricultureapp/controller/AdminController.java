package com.klef.jfsd.sdp.agricultureapp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klef.jfsd.sdp.agricultureapp.model.Admin;
import com.klef.jfsd.sdp.agricultureapp.model.Customer;
import com.klef.jfsd.sdp.agricultureapp.service.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/login")
	   public Map<String, Object> checkAdminLogin(@RequestParam String name, @RequestParam String password) {
	       Admin admin = adminService.checkAdminLogin(name, password);
	       Map<String, Object> response = new HashMap<>();
	       
	       if (admin != null) {
	           response.put("status", "success");
	           response.put("message", "Login successful");
	           response.put("customer", admin);
	       } else {
	           response.put("status", "fail");
	           response.put("message", "Invalid credentials");
	       }
	       
	       return response;
	   }
}
