package com.gnns.web.compost.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gnns.web.compost.model.CompostModel;
import com.gnns.web.login.model.MemberModel;

@Mapper
public interface CompostMapper {

	/**
	 * 부산물 퇴비 신청 상황
	 * @param model
	 * @return
	 */
	public List<CompostModel> getCompostList(CompostModel model);
	
	/**
	 * 신청현황 건수
	 * @param model
	 * @return
	 */
	public CompostModel getCompostListCount(CompostModel model);
	
	
	/**
	 * 신청등록
	 * @param model
	 * @return
	 */
	public int insertCompost(CompostModel model);
	
	/** 신청현황 상세보기 */
	public CompostModel getCompostRead(CompostModel model); // 21-11-02 준혁 추가

	/** 부산물퇴비 관리자 수정 */
	public Integer updateCompost(CompostModel model); // 21-11-02 준혁 추가
	
}