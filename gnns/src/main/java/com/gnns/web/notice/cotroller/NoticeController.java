package com.gnns.web.notice.cotroller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gnns.web.login.model.MemberModel;
import com.gnns.web.notice.model.NoticeModel;
import com.gnns.web.notice.service.NoticeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value={"notice/noticeList"})
	public ModelAndView getNoticeList(NoticeModel model, HttpServletRequest req, RedirectAttributes rttr, MemberModel mModel, Principal pri) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		Map<String, Object> nav = new HashMap<>();
		
		nav.put("urlName", "공지사항");
		nav.put("url", "notice/noticeList");
		
		mav.addObject("nav",nav);
		
		mav.addObject("searchType"	, model.getSearchType());
		mav.addObject("keyword"		, model.getKeyword());
		mav.addObject("page"		, model.getPage());	
				
		mav.setViewName("notice/noticeList");
        return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="notice/getNoticeList")
	public Map<String, Object> getNoticeListData(NoticeModel model) throws Exception{
		Map<String, Object> resMap = new HashMap<String, Object>();
		List<NoticeModel> noticeList = noticeService.getNoticeList(model);
		NoticeModel nModel = noticeService.getNoticeListCount(model);
		
		resMap.put("noticeList", noticeList);
		resMap.put("cnt", nModel);
		return resMap;
	}
	
	@RequestMapping(value={"notice/noticeView"})
	public ModelAndView getNoticeView(NoticeModel model) throws Exception{
		ModelAndView mav = new ModelAndView();
		Map<String, Object> nav = new HashMap<>();
		nav.put("urlName", "공지사항");
		nav.put("url", "notice/noticeView");
		
		mav.addObject("nav",nav);
		
		mav.addObject("notiSeq"		, model.notiSeq);
		mav.addObject("searchType"	, model.getSearchType());
		mav.addObject("keyword"		, model.getKeyword());
		mav.addObject("page"		, model.getPage());
		noticeService.updateNoticeReadCnt(model);
		NoticeModel noticeView = noticeService.getNoticeRead(model);
		mav.addObject("noticeDetail"		, noticeView);
		mav.setViewName("notice/noticeView");
        return mav;
	}
	
	@RequestMapping(value={"price/distributionView"})
	public ModelAndView distributionView(NoticeModel model) throws Exception{
		ModelAndView mav = new ModelAndView();
		Map<String, Object> nav = new HashMap<>();
		nav.put("urlName", "유통정보");
		nav.put("url", "price/distributionView");
		
		mav.addObject("nav",nav);
		
		mav.addObject("notiSeq"		, model.notiSeq);
		mav.addObject("searchType"	, model.getSearchType());
		mav.addObject("keyword"		, model.getKeyword());
		mav.addObject("page"		, model.getPage());
		noticeService.updateNoticeReadCnt(model);
		NoticeModel noticeView = noticeService.getNoticeRead(model);
		mav.addObject("noticeDetail"		, noticeView);
		
		mav.setViewName("price/distributionView");
        return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="notice/getAttachementFile")
	public NoticeModel getNoticeViewData(NoticeModel model) throws Exception{
		NoticeModel noticeView = noticeService.getAttachementFile(model);
		return noticeView;
	}
	
	@RequestMapping(value="notice/noticeWrite")
	public ModelAndView noticeWrite(NoticeModel model) throws Exception{
		ModelAndView mav = new ModelAndView();
		Map<String, Object> nav = new HashMap<>();
		nav.put("urlName", "공지사항");
		nav.put("url", "notice/noticeWrite");
		
		mav.addObject("nav",nav);
		mav.setViewName("notice/noticeWrite");
        return mav;
	}
	
	@RequestMapping(value="notice/noticeRegist")
	public String noticeRegist(NoticeModel model) throws Exception{
		
		model.setRegNm("관리자");
		model.setTag("nohtml");
		int regiStatus=0;
		
		regiStatus= noticeService.updateNotice(model);
		if(regiStatus>0) {
			return "redirect:/notice/adminList"; // 2021-11-10 준혁(수정) 경로 notice/noticeList 에서 변경
		}else {
			return "";
		}
	}
	
	@RequestMapping(value="notice/adminList") // 2021-11-10 준혁(추가)
	public ModelAndView getAdminList(NoticeModel model, HttpServletRequest req, RedirectAttributes rttr, MemberModel mModel, Principal pri) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("searchType"	, model.getSearchType());
		mav.addObject("keyword"		, model.getKeyword());
		mav.addObject("page"		, model.getPage());	
				
		mav.setViewName("notice/adminList");
        return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="notice/getAdminList") // 2021-11-10 준혁(추가)
	public Map<String, Object> getAdminListData(NoticeModel model) throws Exception{
		Map<String, Object> resMap = new HashMap<String, Object>();
		List<NoticeModel> adminList = noticeService.getNoticeList(model);
		NoticeModel nModel = noticeService.getNoticeListCount(model);
		
		resMap.put("adminList", adminList);
		resMap.put("cnt", nModel);
		return resMap;
	}
	
	@RequestMapping(value="notice/adminWrite") // 2021-11-10 준혁(추가)
	public ModelAndView adminWrite(NoticeModel model) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("notice/adminWrite");
        return mav;
	}
	
	@RequestMapping(value={"notice/adminView"}) // 2021-11-10 준혁(추가)
	public ModelAndView getAdminView(NoticeModel model) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("notiSeq"		, model.notiSeq);
		mav.addObject("searchType"	, model.getSearchType());
		mav.addObject("keyword"		, model.getKeyword());
		mav.addObject("page"		, model.getPage());
		noticeService.updateNoticeReadCnt(model);
		NoticeModel noticeView = noticeService.getNoticeRead(model);
		mav.addObject("noticeDetail"		, noticeView);
		mav.setViewName("notice/adminView");
        return mav;
	}
	
	@RequestMapping(value="notice/adminUpdate", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView managementUpdate(NoticeModel model) throws Exception{
		ModelAndView mav = new ModelAndView();
	
		NoticeModel adminView = noticeService.getNoticeRead(model);
		
		mav.addObject("searchType"	, model.getSearchType());
		mav.addObject("keyword"		, model.getKeyword());
		mav.addObject("page"		, model.getPage());
		
		mav.addObject("noticeDtl", adminView);
		mav.setViewName("notice/adminUpdate");
	
		return mav;
	}
	
	@RequestMapping(value="notice/adminDelete")
	public String managermentDelete(NoticeModel model, RedirectAttributes rttr) {
		noticeService.adminDelete(model.getNotiSeq());
		
		rttr.addFlashAttribute("msg", "삭제가 완료 됐습니다.");
		
		return "redirect:/notice/adminList";
	}
	
	@RequestMapping(value="notice/adminWriteUp") // 2021-11-12 준혁(추가)
	public String adminWriteUp(NoticeModel model) throws Exception{
		
		if(model.getAttchementFile() == null) {
			model.setAttchementFile("");
		}
		
		model.setRegNm("관리자");
		model.setTag("nohtml");
		int regiStatus=0;
		model.setContents(model.getContents().replace("|r|n", "<br>"));
		regiStatus= noticeService.insertNotice(model);
		if(regiStatus>0) {
			return "redirect:/notice/adminList"; 
		}else {
			return "";
		}
	}
	
	
}
