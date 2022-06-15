package com.gnns.web.notice.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gnns.web.login.model.MemberModel;
import com.gnns.web.notice.mapper.NoticeMapper;
import com.gnns.web.notice.model.NoticeModel;
import com.gnns.web.notice.service.NoticeService;

@Service
public class NoticeService{
	@Autowired
	private NoticeMapper noticeMapper;
	
	public List<NoticeModel> getNoticeList(NoticeModel model) {
		return noticeMapper.getNoticeList(model);
	}

	public NoticeModel getNoticeRead(NoticeModel model) {
		return noticeMapper.getNoticeRead(model);
	}

	public NoticeModel getNoticeListCount(NoticeModel model){
		return noticeMapper.getNoticeListCount(model);
	}
	public int updateNoticeReadCnt(NoticeModel model) {
		noticeMapper.updateNoticeReadCnt(model);
		return 1;
	}
	
	public int insertNotice(NoticeModel model) {
		noticeMapper.insertNotice(model);
		return 1;
	}
	
	public NoticeModel getAttachementFile(NoticeModel model) {
		return noticeMapper.getAttachementFile(model);
	}

	public int adminDelete(int notiSeq) { // 2021-11-11 준혁(추가)
		return noticeMapper.adminDelete(notiSeq);
	}
	
	public int updateNotice(NoticeModel model) { // 2021-11-12 준혁(추가)
		return noticeMapper.updateNotice(model);
	}

	public List<NoticeModel> getMainNotice() { // 2021-11-17 준혁(추가)
		return noticeMapper.getMainNotice();
	}

}
