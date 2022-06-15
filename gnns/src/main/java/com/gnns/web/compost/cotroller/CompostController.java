package com.gnns.web.compost.cotroller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

import com.gnns.web.board.model.BoardModel;
import com.gnns.web.compost.model.CompostModel;
import com.gnns.web.compost.service.CompostService;
import com.gnns.web.login.model.MemberModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CompostController {

	@Autowired
	private CompostService compostService;

	@RequestMapping(value = "compost/compostInfo")
	public ModelAndView compostInfo(CompostModel model, HttpServletRequest req) throws Exception {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> nav = new HashMap<>();
		nav.put("urlName", "부산물퇴비 소개");
		nav.put("url", "compost/compostInfo");

		mav.addObject("nav", nav);
		mav.setViewName("compost/compostInfo");
		return mav;
	}

	@RequestMapping(value = "compost/compostList")
	public ModelAndView compostList(CompostModel model, HttpServletRequest req) throws Exception {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> nav = new HashMap<>();
		nav.put("urlName", "부산물퇴비 신청현황");
		nav.put("url", "compost/compostList");

		mav.addObject("nav", nav);

		mav.addObject("searchType", model.getSearchType());
		mav.addObject("keyword", model.getKeyword());
		mav.addObject("page", model.getPage());

		mav.setViewName("compost/compostList");
		return mav;
	}

	// 부산물퇴비 신청상황
	@ResponseBody
	@RequestMapping(value = "compost/getCompostList")
	public Map<String, Object> getBidSuccessList(CompostModel model) throws Exception {
		Map<String, Object> resMap = new HashMap<String, Object>();
		// 퇴비신청 현황
		List<CompostModel> resList = compostService.getCompostList(model);
		CompostModel rModel = compostService.getCompostListCount(model);
		resMap.put("compostList", resList);
		resMap.put("cnt", rModel);
		return resMap;
	}

	// 부산물퇴비 지원 등록
	@RequestMapping(value = "compost/compostEnrollment")
	public ModelAndView compostEnrollment(CompostModel model, HttpServletRequest req) throws Exception {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> nav = new HashMap<>();
		nav.put("urlName", "부산물퇴비 신청하기");
		nav.put("url", "compost/compostEnrollment");

		mav.addObject("nav", nav);

		Calendar cal = Calendar.getInstance();
		System.out.println(cal);

		int year = cal.get(Calendar.YEAR);

		List<Integer> arrYear = new ArrayList<Integer>();
		arrYear.add(year);
		arrYear.add(year + 1);
		arrYear.add(year + 2);
		arrYear.add(year + 3);

		mav.addObject("arrYear", arrYear);
		/*
		 * mav.addObject("searchType" , model.getSearchType()); mav.addObject("keyword"
		 * , model.getKeyword()); mav.addObject("page" , model.getPage());
		 */
		mav.setViewName("compost/compostEnrollment");
		return mav;
	}

	@RequestMapping(value = "compost/insertCompost")
	public String insertCompost(CompostModel model, HttpServletRequest req) throws Exception {

		int regiStatus = compostService.insertCompost(model);

		if (regiStatus > 0) {
			return "redirect:/compost/compostInfo";
		} else {
			return "";
		}
	}

	// 부산물퇴비 상세페이지
	@RequestMapping(value = "compost/compostView")
	public ModelAndView getCompostView(CompostModel model) throws Exception {
		ModelAndView mav = new ModelAndView();
		SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		mav.addObject("searchType", model.getSearchType());
		mav.addObject("keyword", model.getKeyword());
		mav.addObject("page", model.getPage());

		CompostModel compostView = compostService.getCompostRead(model);
		
		StringBuffer sb = new StringBuffer(compostView.getReservationDate());
		sb.insert(4, "년 ");
		sb.insert(8, "월 ");

		Date regDt = compostView.getRegDt();

		if (compostView.getReceiptDate() == null) {
			mav.addObject("receiptDate", " ");
		} else {
			Date receiptDate = compostView.getReceiptDate();
			mav.addObject("receiptDate", sdf4.format(receiptDate));
		}

		mav.addObject("reservationDate", sb);
		mav.addObject("regDt", sdf4.format(regDt));
		mav.addObject("compostDetail", compostView);
		mav.setViewName("compost/compostView");
		return mav;
	}

	// 부산물퇴비 수정페이지
	@RequestMapping(value = "compost/compostUpdate", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView compostUpdate(CompostModel model) throws Exception {
		ModelAndView mav = new ModelAndView();
		SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		CompostModel compostView = compostService.getCompostRead(model);

		StringBuffer sb = new StringBuffer(compostView.getReservationDate());
		sb.insert(4, "년 ");
		sb.insert(8, "월 ");
		
		Date regDt = compostView.getRegDt();

		if (compostView.getReceiptDate() == null || compostView.getReceiptMethod() == null) {
			mav.addObject("receiptDate", " ");
			mav.addObject("receiptMethod", " ");
		} else {
			Date receiptDate = compostView.getReceiptDate();
			mav.addObject("receiptDate", sdf4.format(receiptDate));
			mav.addObject("receiptMethod", compostView.getReceiptMethod().trim());
		}
		
		mav.addObject("regDt", sdf4.format(regDt));
		mav.addObject("reservationDate", sb);
		mav.addObject("compostDtl", compostView);
		mav.setViewName("compost/compostUpdate");

		return mav;
	}

	// 부산물퇴비 수정
	@RequestMapping(value = "compost/compostUp")
	public String compostUp(CompostModel model, RedirectAttributes rttr) throws Exception {

		CompostModel memberView = compostService.getCompostRead(model);
		model.setReceiptDate(memberView.getReceiptDate());
		compostService.updateCompost(model);

		rttr.addFlashAttribute("msgView", "수정이 완료 됐습니다.");

		return "redirect:/compost/compostView?seq=" + model.getSeq();
	}
}
