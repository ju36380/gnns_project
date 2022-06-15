package com.gnns.web.pds.cotroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gnns.web.board.model.BoardModel;
import com.gnns.web.login.model.MemberModel;
import com.gnns.web.login.service.LoginService;
import com.gnns.web.pds.model.PdsModel;
import com.gnns.web.pds.service.PdsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PdsController {
	
	@Autowired
	private PdsService pdsService;
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="pds/pdsList")
	public ModelAndView getPdsList(PdsModel model, MemberModel mModel, HttpServletRequest req, RedirectAttributes rttr) throws Exception{
		ModelAndView mav = new ModelAndView();
		Map<String, Object> nav = new HashMap<>();
		nav.put("urlName", "자료실");
		nav.put("url", "pds/pdsList");
		
		mav.addObject("nav",nav);
		
		mav.addObject("searchType"	, model.getSearchType());
		mav.addObject("keyword"		, model.getKeyword());
		mav.addObject("page"		, model.getPage());
		mav.setViewName("pds/pdsList");
        return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="pds//getPdsList")
	public Map<String, Object> getPdsListData(PdsModel model) throws Exception{
		Map<String, Object> resMap = new HashMap<String, Object>();
		List<PdsModel> pdsList = pdsService.getPdsList(model);
		PdsModel nModel = pdsService.getPdsListCount(model);
		resMap.put("pdsList", pdsList);
		resMap.put("cnt", nModel);
		return resMap;
	}
	
	@RequestMapping(value="pds/pdsView")
	public ModelAndView getPdsView(PdsModel model) throws Exception{
		ModelAndView mav = new ModelAndView();
		Map<String, Object> nav = new HashMap<>();
		nav.put("urlName", "자료실");
		nav.put("url", "pds/pdsView");
		
		mav.addObject("nav",nav);
		
		mav.addObject("pdsSeq"		, model.pdsSeq);
		mav.addObject("searchType"	, model.getSearchType());
		mav.addObject("keyword"		, model.getKeyword());
		mav.addObject("page"		, model.getPage());
		pdsService.updatePdsReadCnt(model);
		PdsModel pdsView = pdsService.getPdsRead(model);
		mav.addObject("pdsDetail"		, pdsView);
		mav.setViewName("pds/pdsView");
        return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="pds/getAttachementFile")
	public PdsModel getPdsViewData(PdsModel model) throws Exception{
		PdsModel pdsView = pdsService.getAttachementFile(model);
		return pdsView;
	}
	
	@RequestMapping(value="pds/pdsWrite")
	public ModelAndView pdsWrite(PdsModel model) throws Exception{
		ModelAndView mav = new ModelAndView();
		Map<String, Object> nav = new HashMap<>();
		nav.put("urlName", "자료실");
		nav.put("url", "pds/pdsWrite");
		
		mav.addObject("nav",nav);
		mav.setViewName("pds/pdsWrite");
        return mav;
	}
	
	@RequestMapping(value="pds/pdsRegist")
	public String pdsRegist(PdsModel model) throws Exception{
		ModelAndView mav = new ModelAndView();		
		model.setRegNm("관리자");
		model.setTag("nohtml");
		int regiStatus=0;
		regiStatus= pdsService.insertPds(model);
		if(regiStatus>0) {
			return "redirect:/pds/pdsList";
		}else {
			return "";
		}
	}
	
	@RequestMapping(value="pds/pdsAdminList") // 2021-11-12 준혁(추가)
	public ModelAndView getPdsAdminList(PdsModel model, MemberModel mModel, HttpServletRequest req, RedirectAttributes rttr) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("searchType"	, model.getSearchType());
		mav.addObject("keyword"		, model.getKeyword());
		mav.addObject("page"		, model.getPage());
		mav.setViewName("pds/pdsAdminList");
        return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="pds/getPdsAdminList") // 2021-11-12 준혁(추가)
	public Map<String, Object> getPdsAdminListData(PdsModel model) throws Exception{
		Map<String, Object> resMap = new HashMap<String, Object>();
		List<PdsModel> pdsAdminList = pdsService.getPdsList(model);
		PdsModel nModel = pdsService.getPdsListCount(model);
		resMap.put("pdsAdminList", pdsAdminList);
		resMap.put("cnt", nModel);
		return resMap;
	}
	
	@RequestMapping(value="pds/pdsAdminView") // 2021-11-12 준혁(추가)
	public ModelAndView getPdsAdminView(PdsModel model) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("pdsSeq"		, model.pdsSeq);
		mav.addObject("searchType"	, model.getSearchType());
		mav.addObject("keyword"		, model.getKeyword());
		mav.addObject("page"		, model.getPage());
		pdsService.updatePdsReadCnt(model);
		PdsModel pdsView = pdsService.getPdsRead(model);
		mav.addObject("pdsDetail"		, pdsView);
		mav.setViewName("pds/pdsAdminView");
        return mav;
	}
	
	@RequestMapping(value="pds/pdsAdminWrite") // 2021-11-12 준혁(추가)
	public ModelAndView pdsAdminWrite(PdsModel model) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("pds/pdsAdminWrite");
        return mav;
	}
	
	@RequestMapping(value="pds/pdsAdminRegist") // 2021-11-12 준혁(추가)
	public String pdsAdminRegist(PdsModel model) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		if(model.getAttchementFile() == null) {
			model.setAttchementFile("");
		}
		model.setRegNm("관리자");
		model.setTag("nohtml");
		int regiStatus=0;
		regiStatus= pdsService.insertPds(model);
		if(regiStatus>0) {
			return "redirect:/pds/pdsAdminList";
		}else {
			return "";
		}
	}
	
	@RequestMapping(value="pds/pdsAdminUpdate") // 2021-11-12 준혁(추가)
	public ModelAndView pdsAdminUpdate(PdsModel model) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		PdsModel pdsDtl = pdsService.pdsRead(model);
		
		mav.addObject("pdsDtl"	, pdsDtl);
		mav.addObject("searchType"	, model.getSearchType());
		mav.addObject("keyword"		, model.getKeyword());
		mav.addObject("page"		, model.getPage());
		
		mav.setViewName("pds/pdsAdminUpdate");
		
        return mav;
	}
	
	@RequestMapping(value="pds/pdsAdminUp") // 2021-11-15 준혁(추가)
	public String PdsUp(PdsModel model) throws Exception{
		
		pdsService.updatePds(model);
		
		return "redirect:/pds/pdsAdminList"; 

	}
	
	@RequestMapping(value="pds/pdsAdminDelete") // 2021-11-15 준혁(추가)
	public String pdsAdminDelete(PdsModel model, RedirectAttributes rttr) {
		pdsService.pdsAdminDelete(model.getPdsSeq());
		
		rttr.addFlashAttribute("msg", "삭제가 완료 됐습니다.");
		
		return "redirect:/pds/pdsAdminList";
	}
	
}
