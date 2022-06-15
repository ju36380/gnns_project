package com.gnns.web.adminlogin.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.gnns.web.adminlogin.model.AdminLoginModel;
import com.gnns.web.login.model.MemberModel;

@Mapper
public interface AdminLoginMapper {
	/**
	 * 로그인
	 * @param param
	 * @return
	 */
	public AdminLoginModel adminSelect(AdminLoginModel model);
//	public void adminSelect(AdminLoginModel model) throws Exception;


	public Optional<AdminLoginModel> adminId(AdminLoginModel model);

	public Integer adminUpdate(AdminLoginModel model);	
	
}
