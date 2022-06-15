package com.gnns.web.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gnns.web.adminlogin.model.AdminLoginModel;
import com.gnns.web.login.model.MemberModel;
import com.gnns.web.login.service.LoginService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="login/login", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView login(
			MemberModel model,
			@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "msg", required = false) String msg
            ) throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.addObject("error",error);
		mav.addObject("msg",msg);
		mav.addObject("usrId", model.getUserId());
		mav.addObject("usrPw", model.getUserPw());
		
		mav.setViewName("login/login");
        return mav;
	}
	
	@RequestMapping(value="login/loginProc")
	public String loginProc(MemberModel model, HttpServletRequest req, RedirectAttributes rttr) throws Exception{
		HttpSession session = req.getSession();
		MemberModel resModel = loginService.selectMember(model);
		if(resModel==null || resModel.getUserId()==null) {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("usrId", model.getUserId());
			rttr.addFlashAttribute("usrPw", model.getUserPw());
			rttr.addFlashAttribute("msg", "아이디 또는 비밀번호가 다릅니다");
			return "redirect:/login/login";
		}else {
			session.setAttribute("member", resModel);
			rttr.addAttribute("userId", resModel.getUserId());
			return "redirect:/";
		}
	}

	@RequestMapping(value="/member/logout")
	public String logOut(MemberModel model) throws Exception{
		RequestContextHolder.getRequestAttributes().removeAttribute("member", RequestAttributes.SCOPE_SESSION);
		return "redirect:/"; 
	}

	 
	 @RequestMapping(value="/accessDeny")
	 public ModelAndView accessDeny(MemberModel model, HttpServletRequest req, RedirectAttributes rttr) throws Exception{
		 ModelAndView mav = new ModelAndView();
		 mav.setViewName("error/access");
		 return mav;
	 }
	 
			
}
