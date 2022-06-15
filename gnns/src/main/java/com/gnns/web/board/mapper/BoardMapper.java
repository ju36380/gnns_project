package com.gnns.web.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gnns.web.board.model.BoardModel;
import com.gnns.web.notice.model.NoticeModel;

@Mapper
public interface BoardMapper {
	/**
	 * 공지사항 목록조회
	 * @param param
	 * @return
	 */
	public List<BoardModel> getBoardList(BoardModel model);
	
	/**
	 * 공지사상 내용 조회
	 * @param param	
	 * @return
	 */
	public BoardModel getBoardRead(BoardModel model);
	
	/**
	 * 공지사항 건수 조회
	 * @param model
	 * @return
	 */
	public BoardModel getBoardListCount(BoardModel model);
	
	/**
	 * 조회건수 업데이트
	 * @param model
	 */
	public void updateBoardReadCnt(BoardModel model);
	
	/**
	 * 게시판 첨부파일
	 * @param model
	 * @return
	 */
	public BoardModel getAttachementFile(BoardModel model);
	
	/**
	 * 게시판 내용 등록 
	 * @param model
	 * @return
	 */
	public int insertBoard(BoardModel model);
	
	/**
	 * 일련번호 조회(REF 컬럼 인서트용)
	 * @param model
	 * @return
	 */
	public int selectMaxBoardSeq(BoardModel model);
	
	/**
	 * 답변 등록시 원문 정보 조회
	 * @param model
	 * @return
	 */
	public BoardModel selectOriginMsgInfo(BoardModel model);

	/**
	 * 답변 등록시 관련 게시글 업데이트
	 * @param model
	 * @return
	 */
	public int updateOriginMsg(BoardModel model);
	
	public BoardModel getBoardReadReply(BoardModel model);

	public BoardModel boardRead(BoardModel model); // 2021-11-12 준혁(추가)

	public int updateBoard(BoardModel model); // 2021-11-12 준혁(추가)

	public int boardAdminDelete(int boardSeq); // 2021-11-12 준혁(추가)


}
