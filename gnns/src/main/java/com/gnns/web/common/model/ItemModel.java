package com.gnns.web.common.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class ItemModel  implements Serializable{
	private static final long serialVersionUID = 39638519446470627L;

	private String pumCode;
	
	private String pumName;
	
	private String searchType;
}
