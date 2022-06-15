package com.gnns.web.cmmn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gnns.web.common.model.ItemModel;
import com.gnns.web.common.model.ZipcodeModel;

@Mapper
public interface CmmnMapper {

	/**
	 * 픔목조회 리스트
	 * @param model
	 * @return
	 */
	public List<ItemModel> getItemList(ItemModel model);
	
	/**
	 * 주소검색
	 * @param model
	 * @return
	 */
	public List<ZipcodeModel> getZipcodeList(ZipcodeModel model);
}