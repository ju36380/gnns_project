package com.gnns.web.price.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gnns.web.pds.model.PdsModel;
import com.gnns.web.price.model.PriceCategoryCodeModel;
import com.gnns.web.price.model.PriceInfoModel;
import com.gnns.web.price.model.PriceModel;

@Mapper
public interface PriceMapper {
	/**
	 * 대분류 조회
	 * @param param
	 * @return
	 */
	public List<PriceCategoryCodeModel> getMainCategory(PriceCategoryCodeModel model);
	
	/**
	 * 소분류 조회
	 * @param param
	 * @return
	 */
	public List<PriceCategoryCodeModel> getSubCategory(PriceCategoryCodeModel model);
	
	
	/**
	 * 실시간가격 정보 조회
	 * @param model
	 * @return
	 */
	public List<PriceInfoModel> getPriceInfoList(PriceInfoModel model);
	
	/**
	 * 데이터 건수조회
	 * @param model
	 * @return
	 */
	public PriceInfoModel getPriceInfoListCount(PriceInfoModel model);

	public List<PriceModel> getAuctionList(PriceModel model); // 2021-11-26 준혁(추가)

	public List<PriceInfoModel> getMainPriceInfo(HashMap<String, Object> map); // 2021-12-15 준혁(추가)
	
}
