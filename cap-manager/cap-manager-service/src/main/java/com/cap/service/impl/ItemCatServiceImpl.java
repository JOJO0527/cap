package com.cap.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.common.pojo.EUTreeNode;
import com.cap.mapper.CapItemCatMapper;
import com.cap.pojo.CapItemCat;
import com.cap.pojo.CapItemCatExample;
import com.cap.pojo.CapItemCatExample.Criteria;
import com.cap.service.ItemCatService;

/**
 * 商品分类管理
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private CapItemCatMapper itemCatMapper;
	@Override
	public List<EUTreeNode> getCatList(long parentId) {
		
		//创建查询条件
		CapItemCatExample example = new CapItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		//根据条件查询
		List<CapItemCat> list = itemCatMapper.selectByExample(example);
		List<EUTreeNode> resultList = new ArrayList<>();
		//把列表转换成treeNodelist
		for (CapItemCat capItemCat : list) {
			EUTreeNode node = new EUTreeNode();
			node.setId(capItemCat.getId());
			node.setText(capItemCat.getName());
			node.setState(capItemCat.getIsParent()?"closed":"open");
			resultList.add(node);
		}
		//返回结果
		return resultList;
	}

}
