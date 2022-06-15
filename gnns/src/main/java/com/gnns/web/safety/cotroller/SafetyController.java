package com.gnns.web.safety.cotroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gnns.web.board.model.BoardModel;
import com.gnns.web.notice.model.NoticeModel;
import com.gnns.web.safety.model.SafetyModel;
import com.gnns.web.safety.service.SafetyService;
import com.gnns.web.shipper.model.SalesHistModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SafetyController {
	
	@Autowired
	private SafetyService safetyService;
	
	@RequestMapping(value="safety/safetyInfo")
	public ModelAndView safetyInfo(SalesHistModel model, HttpServletRequest req) throws Exception{
		ModelAndView mav = new ModelAndView();
		Map<String, Object> nav = new HashMap<>();
		nav.put("urlName", "안전성 검사란?");
		nav.put("url", "safety/safetyInfo");
		
		mav.addObject("nav",nav);
		
		mav.setViewName("safety/safetyInfo");
        return mav;
	}
	
	@RequestMapping(value="safety/safetySystem")
	public ModelAndView safetySystem(SalesHistModel model, HttpServletRequest req) throws Exception{
		ModelAndView mav = new ModelAndView();
		Map<String, Object> nav = new HashMap<>();
		nav.put("urlName", "검사체계");
		nav.put("url", "safety/safetySystem");
		
		mav.addObject("nav",nav);
		
		mav.setViewName("safety/safetySystem");
        return mav;
	}
	
	@RequestMapping(value="safety/safetyResult")
	public ModelAndView safetyResult(SalesHistModel model, HttpServletRequest req) throws Exception{
		ModelAndView mav = new ModelAndView();
		Map<String, Object> nav = new HashMap<>();
		nav.put("urlName", "검사결과");
		nav.put("url", "safety/safetyResult");
		
		mav.addObject("nav",nav);
		
		mav.addObject("searchType"	, model.getSearchType());
		mav.addObject("keyword"		, model.getKeyword());
		mav.addObject("page"		, model.getPage());	
		mav.setViewName("safety/safetyResult");
        return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="safety/getSafetyList")
	public Map<String, Object> getSafetyList(SafetyModel model) throws Exception{
		Map<String, Object> resMap = new HashMap<String, Object>();
		List<SafetyModel> safetyList = safetyService.getSafetyList(model);
		SafetyModel safetyListCnt = safetyService.getSafetyListCnt(model);
		resMap.put("safetyList", safetyList);
		resMap.put("cnt", safetyListCnt);
		return resMap;
	}
	
	@RequestMapping(value={"safety/safetyView"}) // 2021-11-17 준혁(추가)
	public ModelAndView safetyView(SafetyModel model) throws Exception{
		ModelAndView mav = new ModelAndView();
		Map<String, Object> nav = new HashMap<>();
		nav.put("urlName", "검사결과");
		nav.put("url", "safety/safetyView");
		
		mav.addObject("nav",nav);
		
		mav.addObject("boardSeq"	, model.getBoardSeq());
		mav.addObject("searchType"	, model.getSearchType());
		mav.addObject("keyword"		, model.getKeyword());
		mav.addObject("page"		, model.getPage());
		safetyService.updateSafetyReadCnt(model);
		SafetyModel safetyView = safetyService.getSafetyRead(model);
		mav.addObject("safetyDetail"	, safetyView);
		mav.setViewName("safety/safetyView");
        return mav;
	}
	
	@RequestMapping(value="safety/safetyAdminList") // 2021-11-17 준혁(추가)
	public ModelAndView safetyAdminList(SalesHistModel model, HttpServletRequest req) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("searchType"	, model.getSearchType());
		mav.addObject("keyword"		, model.getKeyword());
		mav.addObject("page"		, model.getPage());	
		mav.setViewName("safety/safetyAdminList");
        return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="safety/getSafetyAdminList") // 2021-11-17 준혁(추가)
	public Map<String, Object> getSafetyAdminList(SafetyModel model) throws Exception{
		Map<String, Object> resMap = new HashMap<String, Object>();
		List<SafetyModel> safetyList = safetyService.getSafetyList(model);
		SafetyModel safetyListCnt = safetyService.getSafetyListCnt(model);
		resMap.put("safetyList", safetyList);
		resMap.put("cnt", safetyListCnt);
		return resMap;
	}

	@RequestMapping(value="safety/safetyAdminWrite") // 2021-11-17 준혁(추가)
	public ModelAndView adminWrite(SafetyModel model) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("safety/safetyAdminWrite");
        return mav;
	}
	
	@RequestMapping(value="safety/safetyAdminWriteUp") // 2021-11-17 준혁(추가)
	public String safetyAdminWriteUp(SafetyModel model) throws Exception{
		
		if(model.getAttchementFile() == null) {
			model.setAttchementFile("");
		}
		
		model.setRegNm("관리자");
		model.setTag("nohtml");
		int regiStatus=0;
		model.setContents(model.getContents().replace("|r|n", "<br>"));
		regiStatus= safetyService.insertSafety(model);
		if(regiStatus>0) {
			return "redirect:/safety/safetyAdminList"; 
		}else {
			return "";
		}
	}
	
	@RequestMapping(value={"safety/safetyAdminView"}) // 2021-11-17 준혁(추가)
	public ModelAndView safetyAAdminView(SafetyModel model) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("boardSeq"	, model.getBoardSeq());
		mav.addObject("searchType"	, model.getSearchType());
		mav.addObject("keyword"		, model.getKeyword());
		mav.addObject("page"		, model.getPage());
		safetyService.updateSafetyReadCnt(model);
		SafetyModel safetyView = safetyService.getSafetyRead(model);
		mav.addObject("safetyDetail"		, safetyView);
		mav.setViewName("safety/safetyAdminView");
        return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="safety/getAttachementFile") // 2021-11-17 준혁(추가)
	public SafetyModel getSafetyViewData(SafetyModel model) throws Exception{
		SafetyModel safetyModel = safetyService.getAttachementFile(model);
		return safetyModel;
	}
	
	@RequestMapping(value="safety/safetyAdminUpdate", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView safetyAdminUpdate(SafetyModel model) throws Exception{
		ModelAndView mav = new ModelAndView();
	
		SafetyModel safetyAdminView = safetyService.getSafetyRead(model);
		
		mav.addObject("searchType"	, model.getSearchType());
		mav.addObject("keyword"		, model.getKeyword());
		mav.addObject("page"		, model.getPage());
		
		mav.addObject("safetyDtl", safetyAdminView);
		mav.setViewName("safety/safetyAdminUpdate");
	
		return mav;
	}
	
	@RequestMapping(value="safety/safetyRegist") // 2021-11-17 준혁(추가)
	public String noticeRegist(SafetyModel model) throws Exception{
		
		model.setRegNm("관리자");
		model.setTag("nohtml");
		int regiStatus=0;
		
		regiStatus= safetyService.updateSafety(model);
		if(regiStatus>0) {
			return "redirect:/safety/safetyAdminList";
		}else {
			return "";
		}
	}
	
	@RequestMapping(value="safety/safetyAdminDelete")
	public String managermentDelete(SafetyModel model, RedirectAttributes rttr) {
		safetyService.safetyAdminDelete(model.getBoardSeq());
		
		rttr.addFlashAttribute("msg", "삭제가 완료 됐습니다.");
		
		return "redirect:/safety/safetyAdminList";
	}
	
	
}
