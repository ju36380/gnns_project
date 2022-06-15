package com.gnns.web.login.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gnns.web.login.mapper.LoginMapper;
import com.gnns.web.login.model.MemberModel;

@Service
public class LoginService{
	@Autowired
	private LoginMapper loginMapper;
	
	public MemberModel selectMember(MemberModel model) {
		return loginMapper.selectMember(model);
	}

	public Optional<MemberModel> selectLoginMember(MemberModel model) {
		return loginMapper.selectLoginMember(model);
	}
}
