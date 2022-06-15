package com.gnns.web.compost.model;

import java.io.Serializable;
import java.util.Date;

import com.gnns.web.common.model.CmmnModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CompostModel extends CmmnModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4463298821361498006L;
	
	/**
	 * 일련번호
	 */
	private int seq;
	
	/**
	 * 등록자 이름
	 */
	private String name;
	
	/**
	 * 이메일
	 */
	private String email;
	
	/**
	 * 주민번호
	 */
	private String regNum;
	
	/**
	 * 전화번호
	 */
	private String phoneNum;
	
	/**
	 * 휴대폰번호
	 */
	private String mobilePhone;
	
	/**
	 * 우편번호
	 */
	private String zipCode;
	
	/**
	 * 주소
	 */
	private String address;
	
	/**
	 * 상세주소
	 */
	private String subAddress;
	
	/**
	 * 출하예약일
	 */
	private String reservationDate;
	
	/**
	 * 출하내용
	 */
	private String shipmentIssue;
	
	/**
	 * 등록일자 String -> Date 수정(준혁)
	 */
	private Date regDt;
	
	/**
	 * 예약품목
	 */
	private String breedNm;
	
	/**
	 * 예약품목코드
	 */
	private String breedCode;
	
	/**
	 * 접수상태
	 */
	private String receiptStatus;
	
	/**
	 * 접수자
	 */
	private String receiptName;
	
	/**
	 *접수내용
	 */
	private String receiptContent;
	
	/**
	 * 접수방법
	 */
	private String receiptMethod;
	
	/**
	 *접수일시 String -> Date 수정(준혁)
	 */
	private Date receiptDate;

	
}
