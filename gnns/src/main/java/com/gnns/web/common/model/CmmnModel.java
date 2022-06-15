package com.gnns.web.common.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class CmmnModel  implements Serializable{
	private static final long serialVersionUID = 1L;

	private String regId;
	
	private String updId;

	private String regDttm;

	private String updDttm;
	
	/** 검색조건 */
	private String searchType;
	
	/** 검색어 */
	private String keyword;
	
	/** 현재페이지 */
	private Integer page =1;
	
	/** 페이지갯수 */
    private Integer pitem;
    
    /** 페이지사이즈 */
    private Integer psize = 10;

    /** firstIndex */
    private Integer findex = 1;

    /** lastIndex */
    private Integer lindex = 1;

    /** recordCountPerPage */
    private Integer ppage = 10;
    
    /** total count */
    private Integer totCnt = 0;
    
    /** row number */
    private Integer rnum = 0;
    
    /** 정렬 순위 */
    private Integer orderBySet;
    
    private Integer totPage;
    
    private String mCate1;
    
    private String mCate2;
    
    private String sCate1;
    
    private String sCate2;
    
    private String schStrDate;
    
    private String schEndDate;
    
    private String schDate;
    
	/** 회원구분(타입) 2021-11-02 준혁(추가) */
	private String memberShip;
	
	/** 파일삭제(여부) 2021-11-30 준혁(추가) */
	private String hide;
	
	private String searchSel; // 2022-05-16 준혁(추가) 매장구분
}
