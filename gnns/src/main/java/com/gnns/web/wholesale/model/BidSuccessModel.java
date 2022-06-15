package com.gnns.web.wholesale.model;

import java.io.Serializable;

import com.gnns.web.common.model.CmmnModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BidSuccessModel extends CmmnModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4387574639780134179L;
	/**
	 * 원표번호
	 */
	private String originNumber;
	/**
	 *  생산자
	 */
	private String producer;
	
	/**
	 * 품종
	 */
	private String breedName;
	
	/**
	 * 단량
	 */
	private String unitQty;
	
	/**
	 * 등급/과수
	 */
	private String grade;
	
	/**
	 * 수량
	 */
	private int qty;
	
	/**
	 * 단가
	 */
	private int unitPrice;
	
	/**
	 * 판매액
	 */
	private int salesPrice;
	
	/**
	 * 전일미수
	 */
	private int prevdayAccRecv;
	
	/**
	 * 금일판매
	 */
	private int todaySalesPrice;
	
	/**
	 * 금일입금
	 */
	private int todayDeposit;
	
	/**
	 * 금일미수
	 */
	private int todayAccRecv;
	
	/**
	 *중도매인코드 
	 */
	private String wholesaleCode;
	
	/**
	 * 중도매인명
	 */
	private String wholesaleName;
}
