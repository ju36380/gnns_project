package com.gnns.web.circle.model; // 준혁(추가) 2022-05-12

import java.io.Serializable;

import com.gnns.web.common.model.CmmnModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CircleModel extends CmmnModel implements Serializable{
	
	private static final long serialVersionUID = 311524345146142361L;
	
	public String chulName;	// 출하자
	
	public String saleDate; // 날짜
	
	public int saleSeq; 	// 원표번호
	
	public int dSaleSeq; 	// 일련번호
	
	public String dFarm;	// 생산사

	public String sanName;	// 산지명
	
	public String gmName;	// 품종명
	
	public String dBigo; 	// 비고
	
	public int danQty;		// 중량
	
	public String dDan; // 단위(포장)
	
	public String graName; 	// 등급명
	
	public String dKasu;	// 과수
	
	public int dQty;		// 수량
	
}
