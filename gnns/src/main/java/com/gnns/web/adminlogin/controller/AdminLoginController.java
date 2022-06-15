package com.gnns.web.adminlogin.controller;

import java.security.Principal;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gnns.web.adminlogin.model.AdminLoginModel;
import com.gnns.web.adminlogin.service.AdminLoginService;
import com.gnns.web.login.model.MemberModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AdminLoginController {  // 준혁 추가
	@Autowired
	private AdminLoginService adminLoginService;
		
	@RequestMapping(value="login/adminLogin", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView adminLogin(
			AdminLoginModel model,
			@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "msg", required = false) String msg
            ) throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.addObject("error",error);
		mav.addObject("msg",msg);
		mav.addObject("usrId", model.getUserid());
		mav.addObject("usrPw", model.getPwd());
		
		mav.setViewName("login/adminLogin");
        return mav;
	}	 
	
	@RequestMapping(value="login/adminS") 
	  public String adminS(AdminLoginModel model, HttpServletRequest req, RedirectAttributes rttr) throws Exception{
		  HttpSession session = req.getSession(); 
		  AdminLoginModel resModel = adminLoginService.adminSelect(model); 
		  if(resModel==null || resModel.getUserid()==null) { 
			  session.setAttribute("admin", null);
			  rttr.addFlashAttribute("usrId", model.getUserid());
			  rttr.addFlashAttribute("usrPw", model.getPwd());
			  rttr.addFlashAttribute("msg", "아이디 또는 비밀번호가 다릅니다"); 
			  return "redirect:/login/adminLogin"; 
		  }else { 
			  session.setAttribute("member", resModel); 
			  rttr.addFlashAttribute("userid", resModel.getUserid().trim());
		  return "redirect:/"; 
		  } 
	  }
	
	@RequestMapping(value="admin/logout")
    public ModelAndView logout(HttpSession session) {
        session.invalidate();
        ModelAndView mv = new ModelAndView("redirect:/");
        return mv;
    }

	

	@RequestMapping(value="member/adminUp")
	public String adminUp(AdminLoginModel model, RedirectAttributes rttr, Principal pri) throws Exception{
		String adminId = pri.getName().trim();

		rttr.addAttribute("adminId", adminId);
		
		return "redirect:/member/adminUpdate";
	}
	

	@RequestMapping(value="member/adminUpdate")
	public ModelAndView adminUpdate(AdminLoginModel model) throws Exception{
		ModelAndView mav = new ModelAndView();

		mav.setViewName("member/adminUpdate");
	    return mav;
	}
	
	@RequestMapping(value="member/formUp")
	public String formUp(AdminLoginModel model, RedirectAttributes rttr) throws Exception{
		boolean passUpdate = adminLoginService.adminUpdate(model);

		rttr.addFlashAttribute("msgUp", "관리자 정보수정이 완료됐습니다.");
		
		if(passUpdate) {
			return "redirect:/";
		}else {
			return "";
		}
		
	}
	
	
}

