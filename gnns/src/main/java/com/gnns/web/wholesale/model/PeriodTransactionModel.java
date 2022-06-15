package com.gnns.web.wholesale.model;

import java.io.Serializable;

import com.gnns.web.common.model.CmmnModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PeriodTransactionModel extends CmmnModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4387574639780134179L;
	
	/**
	 * 일자
	 */
	private String saleDate;
	
	/**
	 * 전일미수금
	 */
	private int lastdayRecv;
	
	
	/**
	 * 판매액
	 */
	private int salesPrice;
	
	/**
	 * 입금액
	 */
	private int deposit;
	
	/**
	 * 외상미수금
	 */
	private int creditRecv;
	
	/**
	 *중도매인코드 
	 */
	private String wholesaleCode;
	
	/**
	 * 중도매인명
	 */
	private String wholesaleName;
}
