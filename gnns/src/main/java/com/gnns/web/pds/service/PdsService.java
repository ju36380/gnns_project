package com.gnns.web.pds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gnns.web.board.model.BoardModel;
import com.gnns.web.pds.mapper.PdsMapper;
import com.gnns.web.pds.model.PdsModel;

@Service
public class PdsService{
	@Autowired
	private PdsMapper pdsMapper;
	
	public List<PdsModel> getPdsList(PdsModel model) {
		return pdsMapper.getPdsList(model);
	}

	public PdsModel getPdsRead(PdsModel model) {
		return pdsMapper.getPdsRead(model);
	}

	public PdsModel getPdsListCount(PdsModel model){
		return pdsMapper.getPdsListCount(model);
	}
	public int updatePdsReadCnt(PdsModel model) {
		pdsMapper.updatePdsReadCnt(model);
		return 1;
	}
	
	public int insertPds(PdsModel model) {
		pdsMapper.insertPds(model);
		return 1;
	}
	
	public PdsModel getAttachementFile(PdsModel model) {
		return pdsMapper.getAttachementFile(model);
	}

	public PdsModel pdsRead(PdsModel model) { // 2021-11-12 준혁 (추가)
		return pdsMapper.pdsRead(model);
	}
	
	public int updatePds(PdsModel model) { // 2021-11-15 준혁(추가)
		return pdsMapper.updatePds(model);
	}

	public int pdsAdminDelete(int pdsSeq) {
		return pdsMapper.pdsAdminDelete(pdsSeq);		
	}

	public List<PdsModel> getMainPds() { // 2021-12-17 준혁(추가)
		return pdsMapper.getMainPds();
	}

}
