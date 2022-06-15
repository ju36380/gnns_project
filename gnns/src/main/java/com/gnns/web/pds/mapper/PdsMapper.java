package com.gnns.web.pds.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gnns.web.pds.model.PdsModel;

@Mapper
public interface PdsMapper {
	/**
	 * 공지사항 목록조회
	 * @param param
	 * @return
	 */
	public List<PdsModel> getPdsList(PdsModel model);
	
	/**
	 * 공지사상 내용 조회
	 * @param param
	 * @return
	 */
	public PdsModel getPdsRead(PdsModel model);
	
	/**
	 * 공지사항 건수 조회
	 * @param model
	 * @return
	 */
	public PdsModel getPdsListCount(PdsModel model);
	
	/**
	 * 조회건수 업데이트
	 * @param model
	 */
	public void updatePdsReadCnt(PdsModel model);

	/**
	 * 공지사항등록
	 * @param model
	 */
	public void insertPds(PdsModel model);
	
	public PdsModel getAttachementFile(PdsModel model);

	public PdsModel pdsRead(PdsModel model); // 2021-11-12 준혁(추가)

	public int updatePds(PdsModel model); // 2021-11-15 준혁(추가)

	public int pdsAdminDelete(int pdsSeq); // 2021-11-15 준혁(추가)

	public List<PdsModel> getMainPds(); // 2021-12-17 준혁(추가)
	
}
