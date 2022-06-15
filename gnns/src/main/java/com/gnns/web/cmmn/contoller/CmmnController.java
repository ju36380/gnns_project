package com.gnns.web.cmmn.contoller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gnns.web.cmmn.service.CmmnService;
import com.gnns.web.common.model.ItemModel;
import com.gnns.web.common.model.ZipcodeModel;

@Controller
public class CmmnController {
	@Autowired
	private CmmnService cmmnService;

	@RequestMapping(value="/popup/itemPopup")
	public ModelAndView itemPoup(ItemModel model, HttpServletRequest req) throws Exception{
		ModelAndView mav = new ModelAndView();
		model.setSearchType("popup");
		String pumName = model.getPumName();
		List<ItemModel> itemList = cmmnService.getItemList(model);
		mav.setViewName("popup/itemPopup");
		mav.addObject("pumName", pumName);
		mav.addObject("itemList", itemList);
        return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="popup/getItemList")
	public Map<String, Object> getItem(ItemModel model) throws Exception{
		Map<String, Object> resMap = new HashedMap<>();
		List<ItemModel> itemList = cmmnService.getItemList(model);
		resMap.put("itemList", itemList);
		return resMap;
	}
	
	@ResponseBody
	@RequestMapping(value="/popup/zipcodePopup")
	public Map<String, Object> zipcodePopup(ZipcodeModel model, HttpServletRequest req) throws Exception{
		Map<String, Object> resMap = new HashedMap<>();
		List<ZipcodeModel> zipList = cmmnService.getZipcodeList(model);
		resMap.put("zipList", zipList);
		return resMap;
	}
}


