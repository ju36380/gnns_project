package com.gnns.web.wholesale.cotroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gnns.web.member.mapper.UserCustom;
import com.gnns.web.wholesale.model.BidSuccessModel;
import com.gnns.web.wholesale.model.PeriodTransactionModel;
import com.gnns.web.wholesale.service.WholesaleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class WholesaleController {
	
	@Autowired
	private WholesaleService wholesaleService;
	
	
	@RequestMapping(value="wholesale/bidSuccessList")
	public ModelAndView bidSuccessList(BidSuccessModel model, HttpServletRequest req) throws Exception{
		ModelAndView mav = new ModelAndView();
		Map<String, Object> nav = new HashMap<>();
		nav.put("urlName", "일자별 낙찰명세서");
		nav.put("url", "wholesale/bidSuccessList");
		
		mav.addObject("nav",nav);
		mav.setViewName("wholesale/bidSuccessList");
        return mav;
	}
	
	//낙찰내역 조회
	@ResponseBody
	@RequestMapping(value="wholesale/getBidSuccessList")
	public Map<String, Object> getBidSuccessList(BidSuccessModel model, @AuthenticationPrincipal UserCustom user) throws Exception{
		Map<String, Object> resMap = new HashMap<String, Object>();
		model.setWholesaleCode(user.getSalerCd());
		//낙찰 목록
		List<BidSuccessModel> bidSucList = wholesaleService.getBidSuccessList(model);
		resMap.put("bidSucList", bidSucList);
		return resMap;
	}
	
	
	
	@RequestMapping(value="wholesale/periodList")
	public ModelAndView originTransaction(PeriodTransactionModel model, HttpServletRequest req) throws Exception{
		ModelAndView mav = new ModelAndView();
		Map<String, Object> nav = new HashMap<>();
		nav.put("urlName", "기간별 거래원장");
		nav.put("url", "wholesale/periodList");
		
		mav.addObject("nav",nav);
		mav.setViewName("wholesale/periodList");
        return mav;
	}
	
	//기간별 거래원장 조회
	@ResponseBody
	@RequestMapping(value="wholesale/getPeriodList")
	public Map<String, Object> getPeriodList(PeriodTransactionModel model, @AuthenticationPrincipal UserCustom user) throws Exception{
		Map<String, Object> resMap = new HashMap<String, Object>();
		//기간별 거래원장 목록
		model.setWholesaleCode(user.getSalerCd());
		List<PeriodTransactionModel> resList = wholesaleService.getOriginTransaction(model);
		resMap.put("bidSucList", resList);
		return resMap;
	}
}
