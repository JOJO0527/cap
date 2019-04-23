package com.cap.rest.service;

import com.cap.common.pojo.TaotaoResult;

public interface ItemService {

	TaotaoResult getItemBaseInfo(long itemId);
	TaotaoResult getItemDesc(long itemId);
	TaotaoResult getItemParam(long itemId);
}
