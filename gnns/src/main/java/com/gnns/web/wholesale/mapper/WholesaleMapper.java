package com.gnns.web.wholesale.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gnns.web.wholesale.model.BidSuccessModel;
import com.gnns.web.wholesale.model.PeriodTransactionModel;

@Mapper
public interface WholesaleMapper {
	/**
	 * 낙찰내역 조회
	 * @param model
	 * @return
	 */
	public List<BidSuccessModel> getBidSuccessList(BidSuccessModel model);
	
	
	/**
	 * 기간별 거래원장
	 * @param model
	 * @return
	 */
	public List<PeriodTransactionModel> getOriginTransaction(PeriodTransactionModel model);
}