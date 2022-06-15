package com.gnns.web.notice.model;

import java.io.Serializable;

import com.gnns.web.common.model.CmmnModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class NoticeModel extends CmmnModel implements Serializable {

	private static final long serialVersionUID = 311524345146142361L;
	
	/** 공지순번 */
	public int notiSeq;
	
	/** 제목 */
	public String subject;
	
	/** 내용 */
	public String contents;
	
	/** 첨부파일Id */
	public String attchementFile = "";
	
	/** 조회건수 */
	public int readCnt;
	
	/** 파일첨부여부 */
	public String attchementFileRegYn;
	
	/**등록자*/
	public String regNm;
	
	/**파일형식*/
	public String exeType;
	
	/**게시글 번호*/
	public int rowNum;
	
	/**태그*/
	private String tag="";
	
	private String filePath;
	
	private String articleType;
}
