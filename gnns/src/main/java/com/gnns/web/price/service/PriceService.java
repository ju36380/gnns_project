package com.gnns.web.price.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gnns.web.notice.model.NoticeModel;
import com.gnns.web.pds.mapper.PdsMapper;
import com.gnns.web.pds.model.PdsModel;
import com.gnns.web.price.mapper.PriceMapper;
import com.gnns.web.price.model.PriceCategoryCodeModel;
import com.gnns.web.price.model.PriceInfoModel;
import com.gnns.web.price.model.PriceModel;

@Service
public class PriceService{
	@Autowired
	private PriceMapper priceMapper;
	
	public List<PriceCategoryCodeModel> getMainCategory(PriceCategoryCodeModel model) {
		return priceMapper.getMainCategory(model);
	}

	public List<PriceCategoryCodeModel> getSubCategory(PriceCategoryCodeModel model) {
		return priceMapper.getSubCategory(model);
	}
	
	public List<PriceInfoModel> getPriceInfoList(PriceInfoModel model){
		return priceMapper.getPriceInfoList(model);
	}
	
	public PriceInfoModel getPriceInfoListCount(PriceInfoModel model) {
		return priceMapper.getPriceInfoListCount(model);
	}

	public List<PriceModel> getAuctionList(PriceModel model) { // 2021-11-26 준혁(추가)
		return priceMapper.getAuctionList(model);
	}

	public List<PriceInfoModel> getMainPriceInfo(HashMap<String, Object> map) { // 2021-12-15 준혁(추가)
		return priceMapper.getMainPriceInfo(map);
	}
}
