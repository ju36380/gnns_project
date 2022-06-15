package com.gnns.web.contoller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.gnns.web.login.model.MemberModel;
import com.gnns.web.login.service.LoginService;
import com.gnns.web.notice.model.NoticeModel;
import com.gnns.web.notice.service.NoticeService;
import com.gnns.web.pds.model.PdsModel;
import com.gnns.web.pds.service.PdsService;
import com.gnns.web.price.model.PriceInfoModel;
import com.gnns.web.price.service.PriceService;

@Controller
public class MainController {
	@Autowired
	private PdsService pdsService;
	@Autowired
	private PriceService priceService;
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="/")
	public ModelAndView main(MemberModel model, HttpServletRequest req) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		mav.addObject("name",auth.getName());
		mav.addObject("auth",auth.getAuthorities());
		
		mav.setViewName("main/main");
		return mav;
	}
	
	@ResponseBody // 2021-12-15 메인 실시간 시세정보 준혁(추가)
	@RequestMapping(value="/main/getMainPriceInfo")
	public Map<String, Object> getMainPriceInfo() throws Exception{
		Map<String, Object> resMap = new HashMap<String, Object>();
		
		HashMap<String,Object> map = new HashMap<String,Object>(); // 한달 전, 현재날짜	
		Calendar mon = Calendar.getInstance(); // 한달 전
		mon.add(Calendar.MONTH, -1);
		String preDay = new  java.text.SimpleDateFormat("yyyy-MM-dd").format(mon.getTime());
		
		SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd"); // 현재날짜
		String nowDay = format.format(System.currentTimeMillis());
		
		map.put("preDay", preDay);
		map.put("nowDay", nowDay);
		
		List<PriceInfoModel> mainPrice = priceService.getMainPriceInfo(map);
		resMap.put("mainPrice", mainPrice);
		
		return resMap;
	}
	
	@ResponseBody // 2021-12-17 메인 공지사항 준혁(추가)
	@RequestMapping(value="/main/getMainNotice")
	public Map<String, Object> getMainNotice() throws Exception{
		Map<String, Object> resMap = new HashMap<String, Object>();
		
		
		List<NoticeModel> mainNotice = noticeService.getMainNotice();
		resMap.put("mainNotice", mainNotice);
		
		return resMap;
	}
	
	@ResponseBody // 2021-12-17 메인 자료실 준혁(추가)
	@RequestMapping(value="/main/getMainPds")
	public Map<String, Object> getMainPds() throws Exception{
		Map<String, Object> resMap = new HashMap<String, Object>();

		List<PdsModel> mainPds = pdsService.getMainPds();
		resMap.put("mainPds", mainPds);
		
		return resMap;
	}
	
}
