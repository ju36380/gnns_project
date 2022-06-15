package com.gnns.web.board.cotroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gnns.web.board.model.BoardModel;
import com.gnns.web.board.service.BoardService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="board/boardList")
	public ModelAndView getBoardList(BoardModel model, HttpServletRequest req) throws Exception{
		ModelAndView mav = new ModelAndView();
		Map<String, Object> nav = new HashMap<>();
		nav.put("urlName", "게시판");
		nav.put("url", "notice/boardList");
		
		mav.addObject("nav",nav);
		mav.addObject("searchType"	, model.getSearchType());
		mav.addObject("keyword"		, model.getKeyword());
		mav.addObject("page"		, model.getPage());
		
		mav.setViewName("board/boardList");
        return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="board/getBoardList")
	public Map<String, Object> getBoardListData(BoardModel model) throws Exception{
		Map<String, Object> resMap = new HashMap<String, Object>();
		List<BoardModel> boardList = boardService.getBoardList(model);
		BoardModel nModel = boardService.getBoardListCount(model);
		resMap.put("boardList", boardList);
		resMap.put("cnt", nModel);
		return resMap;
	}
	
	@RequestMapping(value="board/boardView")
	public ModelAndView getBoardView(BoardModel model) throws Exception{
		ModelAndView mav = new ModelAndView();
		Map<String, Object> nav = new HashMap<>();
		nav.put("urlName", "게시판");
		nav.put("url", "notice/boardView");
		
		mav.addObject("nav",nav);
		mav.addObject("boardSeq"	, model.boardSeq);
		mav.addObject("searchType"	, model.getSearchType());
		mav.addObject("keyword"		, model.getKeyword());
		mav.addObject("page"		, model.getPage());
		boardService.updateBoardReadCnt(model);
		
		BoardModel boardDetail = boardService.getBoardRead(model);
		if(boardDetail.getAttchementFile() == null) {
			System.out.println("------------" + boardDetail.getAttchementFile());
			boardDetail.setAttchementFile("");
			System.out.println("------------22" + boardDetail.getAttchementFile());
		}
		mav.addObject("boardDetail"		, boardDetail);
		mav.setViewName("board/boardView");
        return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="board/getAttachementFile")
	public BoardModel getBoardViewData(BoardModel model) throws Exception{
		  BoardModel boardView = boardService.getAttachementFile(model);
		  return boardView; 
	  }
	
	/*
	 * public Map<String, Object> getAttachementFile(BoardModel model) throws
	 * Exception{ Map<String, Object> resMap = new HashMap<String, Object>();
	 * BoardModel boardModel = boardService.getAttachementFile(model);
	 * resMap.put("boardModel", boardModel);
	 * 
	 * return resMap; }
	 */
	
	/*
	 * public BoardModel getBoardViewData(BoardModel model) throws Exception{
	 * BoardModel boardView = boardService.getAttachementFile(model); return
	 * boardView; }
	 */
	
	@RequestMapping(value="board/boardWrite")
	public ModelAndView boardWrite(BoardModel model) throws Exception{
		ModelAndView mav = new ModelAndView();
		Map<String, Object> nav = new HashMap<>();
		nav.put("urlName", "게시판");
		nav.put("url", "notice/boardWrite");
		
		mav.addObject("nav",nav);
		mav.setViewName("board/boardWrite");
		mav.addObject("boardType", "origin");
        return mav;
	}
	
	@RequestMapping(value="board/boardRegist")
	public String boardRegist(BoardModel model) throws Exception{
		ModelAndView mav = new ModelAndView();
		if("origin".equals(model.getBoardType())) {
			//입력한 내용이 원문인경우
			int ref = boardService.selectMaxBoardSeq(model);
			model.setRef(ref);
			model.setReStep(0);
			model.setReLevel(0);
		}else {
			//답변 등록인 경우
			BoardModel orgModel = new BoardModel();
			orgModel = boardService.selectOriginMsgInfo(model);
			boardService.updateOriginMsg(model);
			model.setRef(orgModel.getRef());
			model.setReStep(orgModel.getReStep()+1);
			model.setReLevel(orgModel.getReLevel()+1);
		}
		
		if(model.getAttchementFile() == null) {
			model.setAttchementFile("");
		}
		
		model.setTag("nohtml");
		int regiStatus=0;
		regiStatus= boardService.insertBoard(model);
		if(regiStatus>0) {
			return "redirect:/board/boardList";
		}else {
			return "";
		}
	}
	
	@RequestMapping(value="board/boardPwPassD") // 2021-11-16 준혁(추가)
	public ModelAndView boardPwPassD(BoardModel model) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("boardSeq"	, model.getBoardSeq());
		mav.setViewName("board/boardPwPassD");
		return mav;
	}
	
	@RequestMapping(value="board/boardPassDe") // 2021-11-16 준혁(추가)
	public String boardPassDe(BoardModel model, RedirectAttributes rttr) {
		
		String passPw = model.getPassWd().trim();
		BoardModel bModel = boardService.boardRead(model);
		String nowPw = bModel.getPassWd().trim();
		
		if(passPw.equals(nowPw)) {
			boardService.boardAdminDelete(model.getBoardSeq());
			
			rttr.addFlashAttribute("msg", "삭제가 완료 됐습니다.");
			
			return "redirect:/board/boardList";
		}else {
			rttr.addFlashAttribute("msg", "비밀번호가 일치하지 않습니다.");
			return "redirect:/board/boardPwPassD?boardSeq="+bModel.getBoardSeq();
		}
		
		
	}
	
	
	@RequestMapping(value="board/boardPwPass") // 2021-11-15 준혁(추가)
	public ModelAndView boardPwPass(BoardModel model) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("boardSeq"	, model.getBoardSeq());
		mav.setViewName("board/boardPwPass");
		return mav;
	}
	
	@RequestMapping(value="board/boardPassUp") // 2021-11-15 준혁(추가)
	public String boardPassUp(BoardModel model, RedirectAttributes rttr) {
		
		String passPw = model.getPassWd().trim(); // 검사창에 입력 한 비밀번호 2021-11-15 준혁(추가)
		BoardModel bModel = boardService.boardRead(model);
		String nowPw = bModel.getPassWd().trim();
		
		if(passPw.equals(nowPw)) {
			rttr.addFlashAttribute("boardSeq", bModel.getBoardSeq());
			return "redirect:/board/boardUpdate?boardSeq="+bModel.getBoardSeq();
		}else {
			rttr.addFlashAttribute("msg", "비밀번호가 일치하지 않습니다.");
			return "redirect:/board/boardPwPass?boardSeq="+bModel.getBoardSeq();
		}
		
		
	}
	
	
	@RequestMapping(value="board/boardUpdate") // 2021-11-15 준혁(추가)
	public ModelAndView boardUpdate(BoardModel model) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		BoardModel boardDtl = boardService.boardRead(model);
		
		
		mav.addObject("boardDtl"	, boardDtl);
		mav.addObject("boardType"	, "reply");
		mav.addObject("boardSeq"	, model.boardSeq);
		mav.addObject("searchType"	, model.getSearchType());
		mav.addObject("keyword"		, model.getKeyword());
		mav.addObject("page"		, model.getPage());
		mav.setViewName("board/boardUpdate");
		
        return mav;
		
		
	}
	
	@RequestMapping(value="board/boardUp") // 2021-11-15 준혁(추가)
	public String BoardUp(BoardModel model) throws Exception{
		
			boardService.updateBoard(model);

			return "redirect:/board/boardList"; 

	}
	
	@RequestMapping(value="board/boardReply")
	public ModelAndView boardReply(BoardModel model) throws Exception{
		ModelAndView mav = new ModelAndView();
		Map<String, Object> nav = new HashMap<>();
		nav.put("urlName", "게시판");
		nav.put("url", "notice/boardReply");
		
		mav.addObject("nav",nav);
		BoardModel boardDetail = boardService.getBoardReadReply(model);
		mav.addObject("boardDetail"	, boardDetail);
		mav.addObject("boardType"	, "reply");
		mav.addObject("boardSeq"	, model.boardSeq);
		mav.addObject("searchType"	, model.getSearchType());
		mav.addObject("keyword"		, model.getKeyword());
		mav.addObject("page"		, model.getPage());
		mav.setViewName("board/boardReply");
        return mav;
	}
	
	@RequestMapping(value="board/boardAdminList") // 2021-11-11 준혁(추가)
	public ModelAndView getBoardAdminList(BoardModel model, HttpServletRequest req) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("searchType"	, model.getSearchType());
		mav.addObject("keyword"		, model.getKeyword());
		mav.addObject("page"		, model.getPage());
		
		mav.setViewName("board/boardAdminList");
        return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="board/getBoardAdminList") // 2021-11-11 준혁(추가)
	public Map<String, Object> getBoardAdminListData(BoardModel model) throws Exception{
		Map<String, Object> resMap = new HashMap<String, Object>();
		List<BoardModel> boardAdminList = boardService.getBoardList(model);
		BoardModel nModel = boardService.getBoardListCount(model);
		resMap.put("boardAdminList", boardAdminList);
		resMap.put("cnt", nModel);
		return resMap;
	}
	
	@RequestMapping(value="board/boardAdminView") // 2021-11-11 준혁(추가)
	public ModelAndView getBoardAdminView(BoardModel model) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("boardSeq"	, model.boardSeq);
		mav.addObject("searchType"	, model.getSearchType());
		mav.addObject("keyword"		, model.getKeyword());
		mav.addObject("page"		, model.getPage());

		boardService.updateBoardReadCnt(model);
		
		BoardModel boardDetail = boardService.getBoardRead(model);
		if(boardDetail.getAttchementFile() == null) {
			boardDetail.setAttchementFile("");
		}
		mav.addObject("boardDetail"		, boardDetail);
		mav.setViewName("board/boardAdminView");
        return mav;
	}
	
	
	@RequestMapping(value="board/boardAdminWrite") // 2021-11-11 준혁(추가)
	public ModelAndView boardAdminWrite(BoardModel model) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("board/boardAdminWrite");
		mav.addObject("boardType", "origin");
        return mav;
	}
	
	@RequestMapping(value="board/boardAdminRegist") // 2021-11-11 준혁(추가)
	public String boardAdminRegist(BoardModel model) throws Exception{
		ModelAndView mav = new ModelAndView();
		if("origin".equals(model.getBoardType())) {
			//입력한 내용이 원문인경우
			int ref = boardService.selectMaxBoardSeq(model);
			model.setRef(ref);
			model.setReStep(0);
			model.setReLevel(0);
		}else {
			//답변 등록인 경우
			BoardModel orgModel = new BoardModel();
			orgModel = boardService.selectOriginMsgInfo(model);
			boardService.updateOriginMsg(model);
			model.setRef(orgModel.getRef());
			model.setReStep(orgModel.getReStep()+1);
			model.setReLevel(orgModel.getReLevel()+1);
		}
		
		if(model.getAttchementFile() == null) {
			model.setAttchementFile("");
		}
		
		model.setTag("nohtml");
		int regiStatus=0;
		regiStatus= boardService.insertBoard(model);
		if(regiStatus>0) {
			return "redirect:/board/boardAdminList";
		}else {
			return "";
		}
	}
	
	@RequestMapping(value="board/boardAdminReply") // 2021-11-11 준혁(추가)
	public ModelAndView boardAdminReply(BoardModel model) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		BoardModel boardDetail = boardService.getBoardReadReply(model);
		mav.addObject("boardDetail"	, boardDetail);
		mav.addObject("boardType"	, "reply");
		mav.addObject("boardSeq"	, model.boardSeq);
		mav.addObject("searchType"	, model.getSearchType());
		mav.addObject("keyword"		, model.getKeyword());
		mav.addObject("page"		, model.getPage());
		mav.setViewName("board/boardAdminReply");
        return mav;
	}
	
	
	@RequestMapping(value="board/boardAdminUpdate") // 2021-11-12 준혁(추가)
	public ModelAndView boardAdminUpdate(BoardModel model) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		BoardModel boardDtl = boardService.boardRead(model);
		
		mav.addObject("boardDtl"	, boardDtl);
		mav.addObject("boardType"	, "reply");
		mav.addObject("boardSeq"	, model.boardSeq);
		mav.addObject("searchType"	, model.getSearchType());
		mav.addObject("keyword"		, model.getKeyword());
		mav.addObject("page"		, model.getPage());
		mav.setViewName("board/boardAdminUpdate");
		
        return mav;
	}
	
	@RequestMapping(value="board/boardAdminUp") // 2021-11-12 준혁(추가)
	public String BoardAdminUp(BoardModel model) throws Exception{
		
			boardService.updateBoard(model);

			return "redirect:/board/boardAdminList"; 

	}
	
	@RequestMapping(value="board/boardAdminDelete") // 2021-11-12 준혁(추가)
	public String boardAdminDelete(BoardModel model, RedirectAttributes rttr) {
		boardService.boardAdminDelete(model.getBoardSeq());
		
		rttr.addFlashAttribute("msg", "삭제가 완료 됐습니다.");
		
		return "redirect:/board/boardAdminList";
	}
	
}
