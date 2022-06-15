package com.gnns.web.shipper.model;

import java.io.Serializable;

import com.gnns.web.common.model.CmmnModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AggregateModel extends CmmnModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4387574639780134179L;

	/**
	 *  생산자
	 */
	private String producer;
	
	/**
	 * 물량
	 */
	private int volume;
	
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
	 * 하역비
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
	 * 출하주 코드
	 */
	private String shipperCode;
	
}
