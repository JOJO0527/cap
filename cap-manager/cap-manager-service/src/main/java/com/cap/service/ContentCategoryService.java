package com.cap.service;

import java.util.List;

import com.cap.common.pojo.EUTreeNode;
import com.cap.common.pojo.TaotaoResult;

public interface ContentCategoryService {

	List<EUTreeNode> getCategoryList(long parentId);
	TaotaoResult insertContentCategory(long parentId, String name);
}
