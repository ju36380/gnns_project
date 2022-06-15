package com.gnns.web.shipper.cotroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gnns.web.member.mapper.UserCustom;
import com.gnns.web.shipper.model.AggregateModel;
import com.gnns.web.shipper.model.SalesHistModel;
import com.gnns.web.shipper.model.UnpaidModel;
import com.gnns.web.shipper.service.ShipperService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ShipperController {
	
	@Autowired
	private ShipperService shipperService;
	
	@RequestMapping(value="shipper/salesHistory")
	public ModelAndView getSalesHistory(SalesHistModel model, HttpServletRequest req) throws Exception{
		ModelAndView mav = new ModelAndView();
		Map<String, Object> nav = new HashMap<>();
		nav.put("urlName", "판매내역");
		nav.put("url", "shipper/salesHistory");
		
		mav.addObject("page", model.getPage());	
		mav.addObject("nav",nav);
		
		mav.setViewName("shipper/salesHistoryList");
        return mav;
	}
	
	//판매일련번호 조회
//	@ResponseBody
//	@RequestMapping(value="shipper/getSalesSeq")
//	public Map<String, Object> getSalesSeq(SalesHistModel model, @AuthenticationPrincipal UserCustom user) throws Exception{
//		
//		Map<String, Object> resMap = new HashMap<String, Object>();
//		String salesSeq = "";
//		model.setShipperCode(user.getShipperCd());
//		if("F".equals(model.getSeqType())){
//			salesSeq = shipperService.getFirstSalesSeq(model);
//		}else if("N".equals(model.getSeqType())){
//			salesSeq = shipperService.getNextSalesSeq(model);
//		}else {
//			salesSeq = shipperService.getPrevSalesSeq(model);
//		}
//		resMap.put("salesSeq", salesSeq);
//		return resMap;
//	}
	
	//판매일련번호 조회 준혁(수정)
	@ResponseBody
	@RequestMapping(value="shipper/getSalesSeq")
	public Map<String, Object> getSalesSeq(SalesHistModel model, @AuthenticationPrincipal UserCustom user) throws Exception{
		
		Map<String, Object> resMap = new HashMap<String, Object>();
		String salesSeq = "";
		String next_salesSeq = "";
		String pre_salesSeq = "";
		
		model.setShipperCode(user.getShipperCd());
		salesSeq = shipperService.getFirstSalesSeq(model);
		
		model.setSaleSeq(salesSeq);
		next_salesSeq = shipperService.getNextSalesSeq(model);
		pre_salesSeq = shipperService.getPrevSalesSeq(model);
		
		resMap.put("salesSeq", salesSeq);
		resMap.put("nextSeq", next_salesSeq);
		resMap.put("preSeq", pre_salesSeq);
		return resMap;
	}
	
	
	
	//판매이력 조회
	@ResponseBody
	@RequestMapping(value="shipper/salesHistoryList")
	public List<SalesHistModel> salesHistoryList(SalesHistModel model) throws Exception{
		List<SalesHistModel> salesList = shipperService.getSalesHistoryList(model);
		return salesList;
	}
	
	//미지급내역
	@RequestMapping(value="shipper/unpaidList")
	public ModelAndView unpadList(UnpaidModel model, HttpServletRequest req) throws Exception{
		ModelAndView mav = new ModelAndView();
		Map<String, Object> nav = new HashMap<>();
		nav.put("urlName", "미지급내역");
		nav.put("url", "shipper/unpaidList");
		
		mav.addObject("nav",nav);
		mav.setViewName("shipper/unpaidList");
        return mav;
	}
	
	//미지급내역 조회
	@ResponseBody
	@RequestMapping(value="shipper/getUnpaidList")
	public List<UnpaidModel> getUnpaidList(UnpaidModel model, @AuthenticationPrincipal UserCustom user) throws Exception{
		model.setShipperCode(user.getShipperCd());
		List<UnpaidModel> unpaidList = shipperService.getUnpaidList(model);
		return unpaidList;
	}
	
	//실적집계
	@RequestMapping(value="shipper/aggregateList")
	public ModelAndView aggregateList(AggregateModel model, HttpServletRequest req) throws Exception{
		ModelAndView mav = new ModelAndView();
		Map<String, Object> nav = new HashMap<>();
		nav.put("urlName", "실적집계");
		nav.put("url", "shipper/aggregateList");
		
		mav.addObject("nav",nav);
		mav.setViewName("shipper/aggregateList");
	       return mav;
	}
		
	//실적집계 조회
	@ResponseBody
	@RequestMapping(value="shipper/getAggregateList")
	public List<AggregateModel> getAggregateList(AggregateModel model, @AuthenticationPrincipal UserCustom user) throws Exception{
		model.setShipperCode(user.getShipperCd());
		List<AggregateModel> aggregateList = shipperService.getAggregateList(model);
		return aggregateList;
	}
	
}
