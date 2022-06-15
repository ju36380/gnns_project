package com.gnns.web.safety.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gnns.web.notice.model.NoticeModel;
import com.gnns.web.safety.model.SafetyModel;

@Mapper
public interface SafetyMapper {
	
	/**
	 * 안정성 검사 검사결과
	 * @param param
	 * @return
	 */
	public List<SafetyModel> getSafetyList(SafetyModel model);

	/**
	 * 안정성 검사 검사결과 총 CNT
	 * @param param
	 * @return
	 */
	public SafetyModel getSafetyListCnt(SafetyModel model);

	public void updateSafetyReadCnt(SafetyModel model); // 2021-11-17 준혁(추가)

	public SafetyModel getSafetyRead(SafetyModel model); // 2021-11-17 준혁(추가)

	public void insertSafety(SafetyModel model); // 2021-11-17 준혁(추가)

	public SafetyModel getAttachementFile(SafetyModel model); // 2021-11-17 준혁(추가)

	public int updateSafety(SafetyModel model); // 2021-11-17 준혁(추가)

	public int safetyAdminDelete(int boardSeq); // 2021-11-17 준혁(추가)

	
}
