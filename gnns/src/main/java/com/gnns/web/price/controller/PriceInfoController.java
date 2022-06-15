package com.gnns.web.price.controller;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gnns.web.login.model.MemberModel;
import com.gnns.web.pds.model.PdsModel;
import com.gnns.web.price.model.PriceCategoryCodeModel;
import com.gnns.web.price.model.PriceInfoModel;
import com.gnns.web.price.model.PriceModel;
import com.gnns.web.price.service.PriceService;

import lombok.extern.slf4j.Slf4j;
/**
 * 시세정보 조회 컨트롤러 
 *
 */
@Slf4j
@Controller
public class PriceInfoController {
	
	@Autowired
	private PriceService priceService;
	
	/*실시간 시세정보 조회*/
	@RequestMapping(value="price/realTimeAucInfo")
	public ModelAndView realTimeAucInfo(PdsModel model, MemberModel mModel, HttpServletRequest req, RedirectAttributes rttr) throws Exception{
		ModelAndView mav = new ModelAndView();
		Map<String, Object> nav = new HashMap<>();
		nav.put("urlName", "실시간 경매정보");
		nav.put("url", "price/realTimeAucInfo");
		
		mav.addObject("nav",nav);
		mav.setViewName("price/realTimeAucInfo");
        return mav;
	}
	
	/*전자경매 정보*/
	@RequestMapping(value="price/aucInfo")
	public ModelAndView AucInfo(PdsModel model, MemberModel mModel, HttpServletRequest req, RedirectAttributes rttr) throws Exception{
		ModelAndView mav = new ModelAndView();
		Map<String, Object> nav = new HashMap<>();
		nav.put("urlName", "전자경매");
		nav.put("url", "price/aucInfo");
		
		mav.addObject("nav",nav);
		mav.setViewName("price/aucInfo");
        return mav;
	}
	
	/*실시간 시세정보 조회*/
	@RequestMapping(value="price/priceInfoList")
	public ModelAndView getPdsList(PdsModel model, MemberModel mModel, HttpServletRequest req, RedirectAttributes rttr) throws Exception{
		ModelAndView mav = new ModelAndView();
		Map<String, Object> nav = new HashMap<>();
		nav.put("urlName", "시세정보 조회");
		nav.put("url", "price/priceInfoList");
		
		mav.addObject("nav",nav);
		mav.addObject("searchType"	, model.getSearchType());
		mav.addObject("keyword"		, model.getKeyword());
		mav.addObject("page"		, model.getPage());	
		
		mav.setViewName("price/priceInfoList");
        return mav;
	}
	
	//대분류 코드 조회
	@ResponseBody
	@RequestMapping(value="price/getMainCategory")
	public List<PriceCategoryCodeModel> getMainCategory(PriceCategoryCodeModel model) throws Exception{
		List<PriceCategoryCodeModel> mainCategory = priceService.getMainCategory(model);
		return mainCategory;
	}
	
	//소분류 코드 조회
	@ResponseBody
	@RequestMapping(value="price/getSubCategory")
	public List<PriceCategoryCodeModel> getSubCategory(PriceCategoryCodeModel model) throws Exception{
		List<PriceCategoryCodeModel> subCategory = priceService.getSubCategory(model);
		return subCategory;
	}
	
	//시세정보목록 조회
	@ResponseBody
	@RequestMapping(value="price/getPriceInfoList")
	public Map<String, Object> getPriceInfoList(PriceInfoModel model) throws Exception{
		Map<String, Object> resMap = new HashMap<String, Object>();
		List<PriceInfoModel> priceList = priceService.getPriceInfoList(model);
		resMap.put("priceList", priceList);
		return resMap;
		
	}
	
	@GetMapping("/excel/download")
	public void excelDownload(HttpServletResponse response, PriceInfoModel model) throws Exception{
		Workbook wb = new XSSFWorkbook();
		String fileName = "실시간시세정보";
		Sheet sheet = wb.createSheet(fileName);
		Row row = null;
		Cell cell = null;
		int rowNum =0;
		String fileDate = model.getSchEndDate();
		//header
		row = sheet.createRow(rowNum++);
		String[] headerArray = {"품목", "품종", "단량", "단위", "등급", "최저가", "최고가", "평균가"};
		List<PriceInfoModel> priceList = priceService.getPriceInfoList(model);
		for(int i=0; i<headerArray.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(headerArray[i]);
		}
		if(priceList.size()>0) {
			for (PriceInfoModel priceInfoModel : priceList) {
				row = sheet.createRow(rowNum++);
				//cell = row.createCell(i);
				if(priceInfoModel.getItemName()==null) {
					row.createCell(0).setCellValue("");
				}else {
					row.createCell(0).setCellValue(priceInfoModel.getItemName());
				}
				if(priceInfoModel.getBreedName()==null) {
					row.createCell(1).setCellValue("");
				}else {
					row.createCell(1).setCellValue(priceInfoModel.getBreedName());
				}
				if(priceInfoModel.getUnitQty()==null) {
					row.createCell(2).setCellValue("");
				}else {
					row.createCell(2).setCellValue(priceInfoModel.getUnitQty());
				}
				if(priceInfoModel.getUnit()==null) {
					row.createCell(3).setCellValue("");
				}else {
					row.createCell(3).setCellValue(priceInfoModel.getUnit());
				}
				if(priceInfoModel.getGrade()==null) {
					row.createCell(4).setCellValue("");
				}else {
					row.createCell(4).setCellValue(priceInfoModel.getGrade());
				}
				if(priceInfoModel.getLowPrice()==null) {
					row.createCell(5).setCellValue("");
				}else {
					row.createCell(5).setCellValue(priceInfoModel.getLowPrice());
				}
				
				if(priceInfoModel.getMaxPrice()==null) {
					row.createCell(6).setCellValue("");
				}else {
					row.createCell(6).setCellValue(priceInfoModel.getMaxPrice());
				}
				
				if(priceInfoModel.getAvgPrice()==null) {
					row.createCell(7).setCellValue("");
				}else {
					row.createCell(7).setCellValue(priceInfoModel.getAvgPrice());
				}
			}		
		}else {
			row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue("등록된 시세 정보가 없습니다.");
		}
		String excelFileNm = URLEncoder.encode(fileName, "utf-8");
		fileDate = fileDate.replaceAll("-", "");
		
		response.setContentType("ms-vnd/excel");
		response.setHeader("Content-Disposition", "attachment;filename="+excelFileNm+"("+fileDate+").xlsx");
		wb.write(response.getOutputStream());
	    wb.close();
	}
	
	/*유통정보 조회*/
	@RequestMapping(value="price/distributionList")
	public ModelAndView distributionList(PdsModel model, MemberModel mModel, HttpServletRequest req, RedirectAttributes rttr) throws Exception{
		ModelAndView mav = new ModelAndView();
		Map<String, Object> nav = new HashMap<>();
		nav.put("urlName", "유통정보");
		nav.put("url", "price/distributionList");
		
		mav.addObject("nav",nav);
		mav.addObject("searchType"	, model.getSearchType());
		mav.addObject("keyword"		, model.getKeyword());
		mav.addObject("page"		, model.getPage());	
		
		mav.setViewName("price/distributionList");
        return mav;
	}
	
	
	
	@ResponseBody
	@RequestMapping(value="price/getFruitList") // 2021-11-26 준혁(추가) 과일부
	public Map<String, Object> getFruitList(PriceModel model) throws Exception{
		Map<String, Object> resMap = new HashMap<String, Object>();

		model.setDai("1");
		List<PriceModel> priceFruitList = priceService.getAuctionList(model);
		
		resMap.put("priceFruitList", priceFruitList);
		return resMap;
		
	}
	
	@ResponseBody
	@RequestMapping(value="price/getVegeList") // 2021-11-22 준혁(추가) 채소부
	public Map<String, Object> getVegeList(PriceModel model) throws Exception{
		Map<String, Object> resMap = new HashMap<String, Object>();
		
		model.setDai("2");
		List<PriceModel> priceVegeList = priceService.getAuctionList(model);
		
		resMap.put("priceVegeList", priceVegeList);
		return resMap;
	}
	
}
