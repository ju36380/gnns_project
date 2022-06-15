package com.gnns.web.safety.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gnns.web.notice.model.NoticeModel;
import com.gnns.web.safety.mapper.SafetyMapper;
import com.gnns.web.safety.model.SafetyModel;

@Service
public class SafetyService{
	@Autowired
	private SafetyMapper safetyMapper;
	
	public List<SafetyModel> getSafetyList(SafetyModel model) {
		return safetyMapper.getSafetyList(model);
	}
	
	public SafetyModel getSafetyListCnt(SafetyModel model) {
		return safetyMapper.getSafetyListCnt(model);
	}

	public int updateSafetyReadCnt(SafetyModel model) { // 2021-11-17 준혁(추가
		safetyMapper.updateSafetyReadCnt(model);
		return 1;
	}
	
	public SafetyModel getSafetyRead(SafetyModel model) { // 2021-11-17 준혁(추가
		return safetyMapper.getSafetyRead(model);
	}

	public int insertSafety(SafetyModel model) { // 2021-11-17 준혁(추가
		safetyMapper.insertSafety(model);
		return 1;
	}

	public SafetyModel getAttachementFile(SafetyModel model) { // 2021-11-17 준혁(추가
		return safetyMapper.getAttachementFile(model);
	}

	public int updateSafety(SafetyModel model) {
		return safetyMapper.updateSafety(model);
	}

	public int safetyAdminDelete(int boardSeq) { // 2021-11-11 준혁(추가)
		return safetyMapper.safetyAdminDelete(boardSeq);
	}
	
}
