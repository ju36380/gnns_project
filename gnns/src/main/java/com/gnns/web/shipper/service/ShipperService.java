package com.gnns.web.shipper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gnns.web.shipper.mapper.ShipperMapper;
import com.gnns.web.shipper.model.AggregateModel;
import com.gnns.web.shipper.model.SalesHistModel;
import com.gnns.web.shipper.model.UnpaidModel;

@Service
public class ShipperService{
	@Autowired
	private ShipperMapper shipperMapper;
	
	public String getFirstSalesSeq(SalesHistModel model) {
		return shipperMapper.getFirstSalesSeq(model);
	}

	public String getNextSalesSeq(SalesHistModel model) {
		return shipperMapper.getNextSalesSeq(model);
	}
	
	public String getPrevSalesSeq(SalesHistModel model){
		return shipperMapper.getPrevSalesSeq(model);
	}
	
	public List<SalesHistModel> getSalesHistoryList(SalesHistModel model){
		return shipperMapper.getSalesHistoryList(model);
	}
	
	public List<UnpaidModel> getUnpaidList(UnpaidModel model){
		return shipperMapper.getUnpaidList(model);
	}
	
	public List<AggregateModel> getAggregateList(AggregateModel model){
		return shipperMapper.getAggregateList(model);
	}
}
