package com.gnns.web.distributor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DistributorController {
	
	/**
	 * 경매사
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="distributor/actioneer")
	public ModelAndView companyIntorduce() throws Exception{
		ModelAndView mav = new ModelAndView();
		Map<String, Object> nav = new HashMap<>();
		nav.put("urlName", "경매사");
		nav.put("url", "distributor/auctioneer");
		
		mav.addObject("nav",nav);
		mav.setViewName("distributor/auctioneer");
        return mav;
	}
	
	/**
	 * 중도매인
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="distributor/wholesaler")
	public ModelAndView companyOverview() throws Exception{
		ModelAndView mav = new ModelAndView();
		Map<String, Object> nav = new HashMap<>();
		nav.put("urlName", "중도매인");
		nav.put("url", "distributor/wholesaler");
		
		mav.addObject("nav",nav);
		mav.setViewName("distributor/wholesaler");
        return mav;
	}
	
	/**
	 * 매매참가인
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="distributor/trader")
	public ModelAndView companyHistory() throws Exception{
		ModelAndView mav = new ModelAndView();
		Map<String, Object> nav = new HashMap<>();
		nav.put("urlName", "매매참가인");
		nav.put("url", "distributor/trader");
		
		mav.addObject("nav",nav);
		mav.setViewName("distributor/trader");
        return mav;
	}
}
