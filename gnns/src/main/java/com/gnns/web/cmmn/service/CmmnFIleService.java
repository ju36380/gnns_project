package com.gnns.web.cmmn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gnns.web.cmmn.mapper.CmmnFileMapper;
import com.gnns.web.common.model.FileModel;

@Service
public class CmmnFIleService{
	@Autowired
	private CmmnFileMapper cmmnFileMapper;
	
	public String selectFileNm(FileModel model) {
		return cmmnFileMapper.selectFileNm(model);
	}

	public int updateFile(FileModel model) { // 2021-11-18 준혁(추가)
		return cmmnFileMapper.updateFile(model);
	}

	
}
