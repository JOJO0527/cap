package com.cap.rest.service;

import com.cap.common.pojo.TaotaoResult;

public interface RedisService {

	TaotaoResult syncContent(long contentCid);
}
