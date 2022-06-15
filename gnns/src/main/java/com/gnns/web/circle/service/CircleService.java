package com.gnns.web.circle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gnns.web.circle.mapper.CircleMapper;
import com.gnns.web.circle.model.CircleModel;

@Service
public class CircleService {
	
	@Autowired
	private CircleMapper circleMapper;

	public List<CircleModel> getCircleList(CircleModel model) {
		return circleMapper.getCircleList(model);
	}

	public List<CircleModel> getNextSeq(CircleModel model) {
		return circleMapper.getNextSeq(model);
	}

	public List<CircleModel> getPreSeq(CircleModel model) {
		return circleMapper.getPreSeq(model);
	}

	public List<CircleModel> getNowSeq(CircleModel model) {
		return circleMapper.getNowSeq(model);
	}

	public List<CircleModel> getOneSeq(CircleModel model) {
		return circleMapper.getOneSeq(model);
	}

}
