package com.gnns.web.circle.controller; // 준혁(추가)

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gnns.web.circle.model.CircleModel;
import com.gnns.web.circle.service.CircleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CircleController {

	
	@Autowired
	private CircleService circleService;
	
	@RequestMapping(value="circle/circleList")
	public ModelAndView getCircleList(CircleModel model, HttpServletRequest req) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("searchType"	, model.getSearchType());	// 날짜
		mav.addObject("searchSel"		, model.getSearchSel());		// 매장구분
		mav.addObject("dFarm"		, model.getKeyword());		// 생산자
		mav.addObject("saleSeq"		, model.getSaleSeq());			// 원표번호
		mav.setViewName("circle/circleList");
        return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="circle/getCircleList") 
	public Map<String, Object> getCircleList(CircleModel model) throws Exception{
		Map<String, Object> resMap = new HashMap<String, Object>();
		
		List<CircleModel> CircleList = circleService.getCircleList(model);
		
		List<CircleModel> oModel = circleService.getOneSeq(model);
		List<CircleModel> noModel = circleService.getNowSeq(model);
		List<CircleModel> nModel = circleService.getNextSeq(model); 
		List<CircleModel> pModel = circleService.getPreSeq(model);
		
		resMap.put("circleList", CircleList);
		if(!nModel.isEmpty()) {
			resMap.put("nowSeq", noModel); // 현재 원표번호
		}else {
			if(oModel.size() == 0 && noModel.size() == 0) { // 데이터가 없을 시
				resMap.put("oneSeq", 0);
				resMap.put("nowSeq", 0);
			}else {
				resMap.put("oneSeq", oModel); 				
			}
		}
		
		if(!nModel.isEmpty()) {
			resMap.put("nextSeq", nModel); // 다음 원표번호
		}
		
		if(!pModel.isEmpty()) {
			resMap.put("preSeq", pModel); // 이전 원표번호
		}
		return resMap;
	}
	
}
