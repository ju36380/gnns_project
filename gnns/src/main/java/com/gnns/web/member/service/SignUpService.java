package com.gnns.web.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gnns.web.login.model.MemberModel;
import com.gnns.web.member.mapper.SignUpMapper;
import com.gnns.web.notice.model.NoticeModel;

@Service
public class SignUpService{
	@Autowired
	private SignUpMapper signUpMapper;
	
	public Integer idCheck(MemberModel model) {
		return signUpMapper.idCheck(model);
	}
	
	public boolean insertMember(MemberModel model) {
		try {
			signUpMapper.insertMember(model);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	// 21-10-13 준혁 추가
	public String idSearch(MemberModel model) {
	
		return signUpMapper.idSearch(model);
	}
	
	// 21-10-13 준혁 추가
	public String passSearch(MemberModel model) {
		
		return signUpMapper.passSearch(model);
	}
	
	// 21-10-13 준혁 추가
	public boolean passUpdate(MemberModel model) {
		try {
			signUpMapper.passUpdate(model);
			return true;
		}catch(Exception e) {
			return false;
		}		

	}

	
	public List<MemberModel> getManagement(MemberModel model) {
		return signUpMapper.getManagement(model);
	}

	
	public MemberModel getMemberListCount(MemberModel model){
		return signUpMapper.getMemberListCount(model);
	}

	
	public MemberModel getMemberRead(MemberModel model) {
		return signUpMapper.getMemberRead(model);
	}

	public int updateMember(MemberModel model) {
		return signUpMapper.updateMember(model);
	}
	
	public int memberDelete(int seq) {
		return signUpMapper.memberDelete(seq);
	}

}
