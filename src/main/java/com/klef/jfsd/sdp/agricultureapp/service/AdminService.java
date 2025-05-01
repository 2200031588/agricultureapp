package com.klef.jfsd.sdp.agricultureapp.service;

import com.klef.jfsd.sdp.agricultureapp.model.Admin;

public interface AdminService {

	 Admin checkAdminLogin(String name, String password);
}
