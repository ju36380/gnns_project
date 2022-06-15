package com.gnns.web.wholesale.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gnns.web.wholesale.mapper.WholesaleMapper;
import com.gnns.web.wholesale.model.BidSuccessModel;
import com.gnns.web.wholesale.model.PeriodTransactionModel;

@Service
public class WholesaleService{
	@Autowired
	private WholesaleMapper wholesaleMapper;
	
	public List<BidSuccessModel> getBidSuccessList(BidSuccessModel model){
		return wholesaleMapper.getBidSuccessList(model);
	}
	
	public List<PeriodTransactionModel> getOriginTransaction(PeriodTransactionModel model){
		return wholesaleMapper.getOriginTransaction(model);
	}
	
}
