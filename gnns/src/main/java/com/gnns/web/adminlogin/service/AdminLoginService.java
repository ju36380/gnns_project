package com.gnns.web.adminlogin.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gnns.web.adminlogin.mapper.AdminLoginMapper;
import com.gnns.web.adminlogin.model.AdminLoginModel;
import com.gnns.web.login.model.MemberModel;

@Service
public class AdminLoginService{
	@Autowired
	private AdminLoginMapper adminLoginMapper;
	
	public AdminLoginModel adminSelect(AdminLoginModel model) {
		return adminLoginMapper.adminSelect(model);
	}

	public Optional<AdminLoginModel> adminId(AdminLoginModel model) {
		return adminLoginMapper.adminId(model);
	}

	public boolean adminUpdate(AdminLoginModel model) {
		try {
			adminLoginMapper.adminUpdate(model);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
}
