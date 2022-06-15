package com.gnns.web.notice.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gnns.web.notice.model.NoticeModel;

@Mapper
public interface NoticeMapper {
	/**
	 * 공지사항 목록조회
	 * @param param
	 * @return
	 */
	public List<NoticeModel> getNoticeList(NoticeModel model);
	
	/**
	 * 공지사상 내용 조회
	 * @param param
	 * @return
	 */
	public NoticeModel getNoticeRead(NoticeModel model);
	
	/**
	 * 공지사항 건수 조회
	 * @param model
	 * @return
	 */
	public NoticeModel getNoticeListCount(NoticeModel model);
	
	/**
	 * 조회건수 업데이트
	 * @param model
	 */
	public void updateNoticeReadCnt(NoticeModel model);

	/**
	 * 공지사항등록
	 * @param model
	 */
	public void insertNotice(NoticeModel model);
	
	public NoticeModel getAttachementFile(NoticeModel model);

	public Integer adminDelete(int notiSeq); // 2021-11-11 준혁(추가)

	public int updateNotice(NoticeModel model); // 2021-11-11 준혁(추가)

	public List<NoticeModel> getMainNotice(); // 2021-12-17 준혁(추가)
	
}
