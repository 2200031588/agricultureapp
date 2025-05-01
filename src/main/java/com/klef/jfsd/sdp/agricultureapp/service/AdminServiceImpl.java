package com.klef.jfsd.sdp.agricultureapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.sdp.agricultureapp.model.Admin;
import com.klef.jfsd.sdp.agricultureapp.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public Admin checkAdminLogin(String name, String password) {
		 return adminRepository.findByNameAndPassword(name, password);
	}

}
