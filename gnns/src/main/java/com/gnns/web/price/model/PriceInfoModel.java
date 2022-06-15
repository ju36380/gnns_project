package com.gnns.web.price.model;

import java.io.Serializable;
import java.util.Date;

import com.gnns.web.common.model.CmmnModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PriceInfoModel extends CmmnModel implements Serializable {
	private static final long serialVersionUID = 1337977899152365191L;
	private String itemName;
	private String breedName;
	private String unitQty;
	private String unit;
	private String grade;
	private String lowPrice;
	private String maxPrice;
	private String avgPrice;
	private String schStartDtm;
	private String scheNDDtm;
	private String mCate;
	private String sCate;
//	private Date dsaleDate;
}
