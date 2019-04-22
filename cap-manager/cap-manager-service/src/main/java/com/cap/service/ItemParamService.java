package com.cap.service;

import com.cap.common.pojo.TaotaoResult;
import com.cap.pojo.CapItemParam;

public interface ItemParamService {

	TaotaoResult getItemParamByCid(long cid);
	TaotaoResult insertItemParam(CapItemParam itemParam);
}
