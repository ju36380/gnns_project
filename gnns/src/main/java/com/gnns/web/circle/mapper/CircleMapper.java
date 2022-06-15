package com.gnns.web.circle.mapper;

import java.util.List;

import com.gnns.web.circle.model.CircleModel;

public interface CircleMapper {

	public List<CircleModel> getCircleList(CircleModel model);

	public List<CircleModel> getNextSeq(CircleModel model);

	public List<CircleModel> getPreSeq(CircleModel model);

	public List<CircleModel> getNowSeq(CircleModel model);

	public List<CircleModel> getOneSeq(CircleModel model);

}
