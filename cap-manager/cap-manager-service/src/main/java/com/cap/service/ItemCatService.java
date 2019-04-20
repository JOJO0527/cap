package com.cap.service;

import java.util.List;

import com.cap.common.pojo.EUTreeNode;

public interface ItemCatService {

	List<EUTreeNode> getCatList(long parentId);
}
