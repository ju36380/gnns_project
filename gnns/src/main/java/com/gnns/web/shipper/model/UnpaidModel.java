package com.gnns.web.shipper.model;

import java.io.Serializable;

import com.gnns.web.common.model.CmmnModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UnpaidModel extends CmmnModel implements Serializable {
	/**
	 * 생산자, 물량, 판매액, 수수료, 운임, 하역비, 기타공제액
	 */
	private static final long serialVersionUID = -4387574639780134179L;
	
	/**
	 *  생산자
	 */
	private String producer;
	
	/**
	 * 정산액
	 */
	private int settlementAmount;
	
	
	/**
	 * 지불액
	 */
	private int payment;
	
	/**
	 * 현잔액
	 */
	private int balance;
	
	/**
	 * 출하주 코드
	 */
	private String shipperCode;
	
}
