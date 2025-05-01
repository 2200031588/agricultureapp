package com.klef.jfsd.sdp.agricultureapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.sdp.agricultureapp.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String>{

	Admin findByNameAndPassword(String name, String password); 
}
