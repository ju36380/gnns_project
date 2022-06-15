package com.gnns.web.cmmn.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gnns.web.common.model.FileModel;

@Mapper
public interface CmmnFileMapper {
	/**
	 * 첨부파일명 조회
	 * @param param
	 * @return
	 */
	public String selectFileNm(FileModel model);

	public int updateFile(FileModel model);
}
