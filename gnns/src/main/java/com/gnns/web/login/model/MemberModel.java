package com.gnns.web.login.model;

import java.io.Serializable;
import java.util.Date;

import com.gnns.web.common.model.CmmnModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MemberModel extends CmmnModel implements Serializable {

	private static final long serialVersionUID = 311524345146142361L;
	
	/** 일련번호 */
	public int seq;
	
	/** 멤버이름 */
	public String userNm;
	
	/** 이메일 */
	public String email;
	
	/** 주민번호 */
	public String jumin;
	
	/** 사업자번호 */
	public String bizNo;
	
	/** 전화번호 */
	public String telNum;
	
	/**팩스번호*/
	public String faxNum;
	
	/** 휴대폰번호 */
	public String mobNum;
	
	/**우편번호*/
	public String zipCd;
	
	/**주소1*/
	public String addr;
	
	/**주소2*/
	public String addrDtl;
	
	/**메모*/
	public String memo;
	
	/**구분*/
	public String memType;
	
	/**출하주코드*/
	public String shipperCd;
	
	/**중도매인코드*/
	public String salerCd;
	
	/**등록일*/
	public Date regDt; // 2021-11-02(준혁) -> String 타입에서 Date 타입으로 변경
	
	/**승인flag*/
	public String aprvFlag;
	
	/**승인일*/
	public Date aprvDt; // 2021-11-02(준혁) -> String 타입에서 Date 타입으로 변경
	
	/**사유*/
	public String aprvResn;
	
	/**아이디*/
	public String userId;
	
	/**비밀번호*/
	public String userPw;
	
	/** 게시글 번호 */
	public int rowNum;
	
	
}
