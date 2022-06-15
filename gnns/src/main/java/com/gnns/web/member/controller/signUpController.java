package com.gnns.web.member.controller;

import org.apache.poi.util.SystemOutLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gnns.web.board.model.BoardModel;
import com.gnns.web.login.model.MemberModel;
import com.gnns.web.member.service.SignUpService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class signUpController {
	
	@Autowired
	private SignUpService signUpService;
	
	@RequestMapping(value="member/signUp")
	public ModelAndView signUp(MemberModel model) throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/signUp");
	    return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="member/idCheck")
	public Integer getNoticeListData(MemberModel model) throws Exception{
		int resCnt=0;
		resCnt = signUpService.idCheck(model);
		//List<BoardModel> noticeList = boardService.getBoardList(model);
		//BoardModel nModel = boardService.getBoardListCount(model);
		return resCnt;
	}
	
	@RequestMapping(value="member/registMember")
	public String registMember(MemberModel model,RedirectAttributes rttr) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		
		boolean regiStatus=signUpService.insertMember(model);
		rttr.addFlashAttribute("msg", "정상적으로 회원가입 되었습니다. 로그인 해주세요");
		
		if(regiStatus) {
			return "redirect:/login/login";
		}else {
			return "";
		}
	}
	
	// 준혁 연습 21-10-12(아이디 찾기)이동
	@RequestMapping(value="member/idSearch")
	public ModelAndView idSearch(MemberModel model) throws Exception{
		ModelAndView mav = new ModelAndView();

		mav.setViewName("member/idSearch");
	    return mav;
	}
	
	// 준혁 추가 21-10-12(아이디 찾기 버튼 폼 액션)
	@RequestMapping(value="member/searchId")
	public String searchId(MemberModel model, RedirectAttributes rttr) throws Exception{
		String serId=signUpService.idSearch(model);
		
		if(serId == "" || serId == null) {
			rttr.addFlashAttribute("msgId", "정보와 일치된 아이디가 없습니다.");
			return "redirect:/login/login";
		}else {

			serId=serId.substring(0, serId.trim().length()-2);
			
			rttr.addFlashAttribute("serId", serId+"**");
		}
		return "redirect:/member/idFind";
		
	}
	
	// 준혁 연습 21-10-13(비밀번호 찾기)이동
	@RequestMapping(value="member/passSearch")
	public ModelAndView passSearch(MemberModel model) throws Exception{
		ModelAndView mav = new ModelAndView();

		mav.setViewName("member/passSearch");
	    return mav;
	}
	
	// 준혁 추가 21-10-13(비밀번호 찾기 버튼)
	@RequestMapping(value="member/searchPass")
	public String searchPass(MemberModel model, RedirectAttributes rttr) throws Exception{
		String serPass=signUpService.passSearch(model);
		
		if(serPass == "" || serPass == null) {
			rttr.addFlashAttribute("msgPass", "입력해주신 정보와 일치된 회원이 없습니다.");
			return "redirect:/login/login";
		}else {
			String idUpdate=signUpService.idSearch(model);
			idUpdate = idUpdate.trim();
			rttr.addFlashAttribute("idUpdate", idUpdate);
			return "redirect:/member/passUpdate";
		}
		
	}
	
	// 준혁 연습 21-10-13(비밀번호 재설정)이동
	@RequestMapping(value="member/passUpdate")
	public ModelAndView passUpdate(MemberModel model) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		
		mav.setViewName("member/passUpdate");
	    return mav;
	}
	
	// 준혁 연습 21-10-13(비밀번호 재설정 폼 -> 수정)이동
	@RequestMapping(value="member/pwUpdate")
	public String pwUpdate(MemberModel model, RedirectAttributes rttr) throws Exception{
		boolean passUpdate = signUpService.passUpdate(model);

		rttr.addFlashAttribute("msgPassUp", "비밀번호 변경이 완료됐습니다.");
		
		if(passUpdate) {
			return "redirect:/login/login";
		}else {
			return "";
		}
		
	}
	
	// 준혁 연습 21-10-14(아이디 찾기 -> 아이디 출력)이동
	@RequestMapping(value="member/idFind")
	public ModelAndView idFind(MemberModel model) throws Exception{
		ModelAndView mav = new ModelAndView();

		mav.setViewName("member/idFind");
	    return mav;
	}
	
}

