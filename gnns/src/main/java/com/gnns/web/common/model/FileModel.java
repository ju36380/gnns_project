package com.gnns.web.common.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class FileModel  implements Serializable{
	private static final long serialVersionUID = -1423181933000730035L;
	
	/**파일경로*/
	private String filePath;
	
	/**파일명*/
	private String fileName;
	
	private String fileSeq;
	
	private String tbNm;
	
	private String fileType;
	
	private String ext;
	
	private String hide;
}
