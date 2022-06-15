package com.gnns.web.price.model;

import java.io.Serializable;

import com.gnns.web.common.model.CmmnModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PriceCategoryCodeModel extends CmmnModel implements Serializable {
	private static final long serialVersionUID = 1337977899152365191L;

	private String cd;
	
	private String cdNm;
	
}
