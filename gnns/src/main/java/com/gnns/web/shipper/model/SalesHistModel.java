package com.gnns.web.shipper.model;

import java.io.Serializable;

import com.gnns.web.common.model.CmmnModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SalesHistModel extends CmmnModel implements Serializable {
	private static final long serialVersionUID = -7971708652891063478L;
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
	 * 단위
	 */
	private String unit;
	/**
	 * 등급
	 */
	private String grade;
	/**
	 * 수량
	 */
	private String qty;
	
	/**
	 * 단가
	 */
	private String unitPrice;
	/**
	 * 중도매인
	 */
	private String wholesaler;
	
	/**
	 * 판매일
	 */
	private String saleDate;
	
	/**
	 * 판매일련번호
	 */
	private String saleSeq;
	
	/**
	 * 출하주코드
	 */
	private String shipperCode;
	
	/**
	 * 판매액
	 */
	private int salesPrice;
	
	/**
	 * 수수료
	 */
	private int fees;
	
	/**
	 * 운임
	 */
	private int fare;
	/**
	 *하역비
	 */
	private int unloadingFee;
	
	/**
	 * 기타공제액
	 */
	private int otherDeductions;
	/**
	 * 차인잔액
	 */
	private int balance;
	
	/**
	 * 판매일련번호 조회구분
	 */
	private String seqType;
}
