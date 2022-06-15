package com.gnns.web.adminlogin.model;

import java.io.Serializable;

import com.gnns.web.common.model.CmmnModel;

public class AdminLoginModel extends CmmnModel implements Serializable{

	public String userid;
	public String pwd;
		
		
	public String getUserid() { 
		return userid; 
	} 
	  
	public void setUserid(String userid) { 
		this.userid = userid; 
	} 
	  
	public String getPwd() { 
		return pwd; 
	}
	 
	public void setPwd(String pwd) { 
		this.pwd = pwd; 
	}
	 
	
}
