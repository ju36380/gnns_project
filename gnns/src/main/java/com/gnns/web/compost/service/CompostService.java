package com.gnns.web.compost.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gnns.web.compost.mapper.CompostMapper;
import com.gnns.web.compost.model.CompostModel;
import com.gnns.web.login.model.MemberModel;

@Service
public class CompostService{
	@Autowired
	private CompostMapper compostMapper;
	
	public List<CompostModel> getCompostList(CompostModel model){
		return compostMapper.getCompostList(model);
	}
	
	public CompostModel getCompostListCount(CompostModel model) {
		return compostMapper.getCompostListCount(model);
	}
	
	public int insertCompost(CompostModel model){
		return compostMapper.insertCompost(model);
	}

	public CompostModel getCompostRead(CompostModel model) {
		return compostMapper.getCompostRead(model);
	}
	
	public int updateCompost(CompostModel model) {
		return compostMapper.updateCompost(model);
	}
	
}
