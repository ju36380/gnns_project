package com.gnns.web.management.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.gnns.web.login.model.MemberModel;
import com.gnns.web.member.service.MemberService;
import com.gnns.web.member.service.SignUpService;

import groovy.util.logging.Slf4j;

@Slf4j
@Controller
public class managementController { // 준혁 추가 회원관리
	@Autowired
	private SignUpService signUpService;
	
	@RequestMapping(value="member/management")
	public ModelAndView management(HttpServletRequest req, RedirectAttributes rttr, MemberModel model) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("searchType"	, model.getSearchType());
		mav.addObject("keyword"		, model.getKeyword());
		mav.addObject("page"		, model.getPage());
		mav.addObject("memberShip"	, model.getMemberShip());
				
		mav.setViewName("member/management");
        return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="member/getManagement")
	public Map<String, Object> getManagementData(MemberModel model) throws Exception{
		Map<String, Object> resMap = new HashMap<String, Object>();
		List<MemberModel> management = signUpService.getManagement(model);
		MemberModel mModel = signUpService.getMemberListCount(model);
		
		resMap.put("memberList", management);
		resMap.put("cnt", mModel);
		return resMap;
	}
	
	@RequestMapping(value="member/managementView")
	public ModelAndView getManagementView(MemberModel model) throws Exception{
		ModelAndView mav = new ModelAndView();
		SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		mav.addObject("memSeq"		, model.getSeq());
		mav.addObject("searchType"	, model.getSearchType());
		mav.addObject("keyword"		, model.getKeyword());
		mav.addObject("page"		, model.getPage());
		mav.addObject("memberShip"	, model.getMemberShip());
		
		MemberModel memberView = signUpService.getMemberRead(model);
		
		Date regDt = memberView.getRegDt();
		if(memberView.getAprvDt() == null) {
			mav.addObject("aprvDt", " ");
		}else {
			Date aprvDt = memberView.getAprvDt();
			mav.addObject("aprvDt", sdf4.format(aprvDt));
		}
				
		mav.addObject("regDt", sdf4.format(regDt));
		mav.addObject("memberDetail", memberView);
		mav.setViewName("member/managementView");
        return mav;
	}
	
	@RequestMapping(value="member/managementUpdate", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView managementUpdate(MemberModel model) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		MemberModel memberView = signUpService.getMemberRead(model);
		
		if(memberView.getShipperCd() == null) {
			mav.addObject("shipperCd", "");
		}else {
			String shipperCd = memberView.getShipperCd().trim();
			mav.addObject("shipperCd", shipperCd);
		}
		
		Date regDt = memberView.getRegDt();
		SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		mav.addObject("searchType"	, model.getSearchType());
		mav.addObject("keyword"		, model.getKeyword());
		mav.addObject("page"		, model.getPage());
		mav.addObject("memberShip"	, model.getMemberShip());
		mav.addObject("regDt", sdf4.format(regDt));
		mav.addObject("membereDtl", memberView);
		mav.setViewName("member/managementUpdate");
		
		return mav;
	}
	
	@RequestMapping(value="member/memberUp", method=RequestMethod.POST)
	public String memberUp(MemberModel model, RedirectAttributes rttr) throws Exception{
		
		MemberModel memberView = signUpService.getMemberRead(model);
		model.setAprvDt(memberView.getAprvDt());
		signUpService.updateMember(model);
		
		rttr.addFlashAttribute("msgView", "수정이 완료 됐습니다.");

		return "redirect:/member/managementView?seq="+model.getSeq();
	}
	
	@RequestMapping(value="member/managermentDelete")
	public String managermentDelete(MemberModel model, RedirectAttributes rttr) {
		signUpService.memberDelete(model.getSeq());
		
		rttr.addFlashAttribute("msg", "삭제가 완료 됐습니다.");
		
		return "redirect:/member/management";
	}
	
}

