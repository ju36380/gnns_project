package com.gnns.web.cmmn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gnns.web.cmmn.mapper.CmmnMapper;
import com.gnns.web.common.model.ItemModel;
import com.gnns.web.common.model.ZipcodeModel;

@Service
public class CmmnService{
	@Autowired
	private CmmnMapper cmmnMapper;
	
	public List<ItemModel> getItemList(ItemModel model){
		return cmmnMapper.getItemList(model);
	}
	
	public List<ZipcodeModel> getZipcodeList(ZipcodeModel model){
		return cmmnMapper.getZipcodeList(model);
	}
}
