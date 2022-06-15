package com.gnns.web.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gnns.web.board.mapper.BoardMapper;
import com.gnns.web.board.model.BoardModel;
import com.gnns.web.notice.model.NoticeModel;

@Service
public class BoardService{
	@Autowired
	private BoardMapper boardMapper;
	
	public List<BoardModel> getBoardList(BoardModel model) {
		return boardMapper.getBoardList(model);
	}

	public BoardModel getBoardRead(BoardModel model) {
		return boardMapper.getBoardRead(model);
	}

	public BoardModel getBoardListCount(BoardModel model){
		return boardMapper.getBoardListCount(model);
	}
	
	public BoardModel getAttachementFile(BoardModel model) {
		return boardMapper.getAttachementFile(model);
	}
	
	public int updateBoardReadCnt(BoardModel model) {
		boardMapper.updateBoardReadCnt(model);
		return 1;
	}
	
	public int insertBoard(BoardModel model) {
		boardMapper.insertBoard(model);
		return 1;
	}
	
	public int selectMaxBoardSeq(BoardModel model) {
		int refNo = boardMapper.selectMaxBoardSeq(model);
		return refNo;
	}
	
	public BoardModel selectOriginMsgInfo(BoardModel model) {
		return boardMapper.selectOriginMsgInfo(model);
	}

	public int updateOriginMsg(BoardModel model) {
		boardMapper.updateOriginMsg(model);
		return 1;
	}
	
	public BoardModel getBoardReadReply(BoardModel model) {
		return boardMapper.getBoardReadReply(model);
	}

	public BoardModel boardRead(BoardModel model) { // 2021-11-12 준혁(추가)
		return boardMapper.boardRead(model);
	}

	public int updateBoard(BoardModel model) { // 2021-11-12 준혁(추가)
		return boardMapper.updateBoard(model);
	}

	public int boardAdminDelete(int boardSeq) { // 2021-11-12 준혁(추가)
		return boardMapper.boardAdminDelete(boardSeq);
		
	}


}
