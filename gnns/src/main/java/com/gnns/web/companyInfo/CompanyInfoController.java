package com.gnns.web.companyInfo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CompanyInfoController {
	
	/**
	 * 인사말
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="company/introduce")
	public ModelAndView companyIntorduce() throws Exception{
		ModelAndView mav = new ModelAndView();
		Map<String, Object> nav = new HashMap<>();
		nav.put("urlName", "인사말");
		nav.put("url", "company/introduce");
		
		mav.addObject("nav",nav);
		mav.setViewName("company/introduce");
        return mav;
	}
	
	/**
	 * 회사개요
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="company/overview")
	public ModelAndView companyOverview() throws Exception{
		ModelAndView mav = new ModelAndView();
		Map<String, Object> nav = new HashMap<>();
		nav.put("urlName", "회사개요");
		nav.put("url", "company/overview");
		
		mav.addObject("nav",nav);
		mav.setViewName("company/overview");
        return mav;
	}
	
	/**
	 * 연혁
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="company/history")
	public ModelAndView companyHistory() throws Exception{
		ModelAndView mav = new ModelAndView();
		Map<String, Object> nav = new HashMap<>();
		nav.put("urlName", "연혁");
		nav.put("url", "company/history");
		
		mav.addObject("nav",nav);
		mav.setViewName("company/history");
        return mav;
	}
	
	/**
	 * 사업실적
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="company/business")
	public ModelAndView companyBusiness() throws Exception{
		ModelAndView mav = new ModelAndView();
		Map<String, Object> nav = new HashMap<>();
		nav.put("urlName", "사업실적");
		nav.put("url", "company/business");
		
		mav.addObject("nav",nav);
		mav.setViewName("company/business");
        return mav;
	}
	
	/**
	 * CI소개
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="company/ci")
	public ModelAndView companyCi() throws Exception{
		ModelAndView mav = new ModelAndView();
		Map<String, Object> nav = new HashMap<>();
		nav.put("urlName", "CI소개");
		nav.put("url", "company/ci");
		
		mav.addObject("nav",nav);
		mav.setViewName("company/ci");
        return mav;
	}
	
	/**
	 * 조직도
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="company/organization")
	public ModelAndView companyOrganization() throws Exception{
		ModelAndView mav = new ModelAndView();
		Map<String, Object> nav = new HashMap<>();
		nav.put("urlName", "조직도");
		nav.put("url", "company/organization");
		
		mav.addObject("nav",nav);
		mav.setViewName("company/organization");
        return mav;
	}
	
	/**
	 * 약도
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="company/map")
	public ModelAndView companyMap() throws Exception{
		ModelAndView mav = new ModelAndView();
		Map<String, Object> nav = new HashMap<>();
		nav.put("urlName", "약도");
		nav.put("url", "company/map");
		
		mav.addObject("nav",nav);
		mav.setViewName("company/map");
        return mav;
	}
	
	/**
	 * 경영공시
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="company/disclosure")
	public ModelAndView companyDisclosure() throws Exception{
		ModelAndView mav = new ModelAndView();
		Map<String, Object> nav = new HashMap<>();
		nav.put("urlName", "경영공시");
		nav.put("url", "company/disclosure");
		
		mav.addObject("nav",nav);
		mav.setViewName("company/disclosure");
        return mav;
	}

}
