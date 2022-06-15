package com.gnns.web.login.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.gnns.web.login.model.MemberModel;

@Mapper
public interface LoginMapper {
	/**
	 * 로그인
	 * @param param
	 * @return
	 */
	public MemberModel selectMember(MemberModel model);
	
	public Optional<MemberModel> selectLoginMember(MemberModel model);
	
}
