package com.gnns.web.common.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class ZipcodeModel  implements Serializable{
	private static final long serialVersionUID = 39638519446470627L;

	private String zipcode;
	
	private String sido;
	
	private String gugun;
	
	private String dong;
	
	private String bunji;
	
	private String seqno;
	
	private String searchKey;
}
