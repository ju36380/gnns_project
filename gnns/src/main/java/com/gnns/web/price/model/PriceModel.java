package com.gnns.web.price.model;

import java.io.Serializable;
import java.util.Date;

import com.gnns.web.common.model.CmmnModel;

import lombok.Data;

@Data
public class PriceModel extends CmmnModel implements Serializable{
	private static final long serialVersionUID = 1337977899152365191L;

	private String dai;
	
	private int ipdSeq;
	
	private String chulName;
	
	private String farm;
	
	private String good;
	
	private String danQty;
	
	private String grade;
	
	private int qty;
	
	private int cost;
	
	private String amer;
	
	private String gubn;
	
	private Date inTime;
	
}
