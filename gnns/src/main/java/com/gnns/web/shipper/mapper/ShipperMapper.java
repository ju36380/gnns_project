package com.gnns.web.shipper.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gnns.web.shipper.model.AggregateModel;
import com.gnns.web.shipper.model.SalesHistModel;
import com.gnns.web.shipper.model.UnpaidModel;

@Mapper
public interface ShipperMapper {
	/**
	 * 판매 이력번호 조회
	 * @param param
	 * @return
	 */
	public String getFirstSalesSeq(SalesHistModel model);
	
	/**
	 * 다음 판매 이력번호 조회
	 * @param model
	 * @return
	 */
	public String getNextSalesSeq(SalesHistModel model);
	
	/**
	 * 이전 판매 이력 번호 조회
	 * @param model
	 * @return
	 */
	public String getPrevSalesSeq(SalesHistModel model);
	
	/**
	 * 판매내역 조회
	 * @param model
	 * @return
	 */
	public List<SalesHistModel> getSalesHistoryList(SalesHistModel model);
	
	
	/**
	 * 미지급내역 조회
	 * @param model
	 * @return
	 */
	public List<UnpaidModel> getUnpaidList(UnpaidModel model);
	
	/**
	 * 실적집계 조회
	 * @param model
	 * @return
	 */
	public List<AggregateModel> getAggregateList(AggregateModel model);
}
