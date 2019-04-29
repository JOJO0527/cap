package com.cap.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cap.mapper.CapItemCatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cap.pojo.CapItemCat;
import com.cap.pojo.CapItemCatExample;
import com.cap.pojo.CapItemCatExample.Criteria;
import com.cap.rest.pojo.CatNode;
import com.cap.rest.pojo.CatResult;
import com.cap.rest.service.ItemCatService;

/**
 * 商品分类服务
 * <p>Title: ItemCatServiceImpl</p>
 */
@SuppressWarnings("unchecked")
@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private CapItemCatMapper itemCatMapper;
	
	@Override
	public CatResult getItemCatList() {
		
		CatResult catResult = new CatResult();
		//查询分类列表
		catResult.setData(getCatList(0));
		return catResult;
	}
	
	/**
	 * 查询分类列表
	 * <p>Title: getCatList</p>
	 * <p>Description: </p>
	 * @param parentId
	 * @return
	 */
	private List<?> getCatList(long parentId) {
		//创建查询条件
		CapItemCatExample example = new CapItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		//执行查询
		List<CapItemCat> list = itemCatMapper.selectByExample(example);
		//返回值list
		List resultList = new ArrayList<>();
		//向list中添加节点
		int count = 0;
		for (CapItemCat capItemCat : list) {
			//判断是否为父节点
			if (capItemCat.getIsParent()) {
				CatNode catNode = new CatNode();
				if (parentId == 0) {
					catNode.setName("<a href='/products/"+capItemCat.getId()+".html'>"+capItemCat.getName()+"</a>");
				} else {
					catNode.setName(capItemCat.getName());
				}
				catNode.setUrl("/products/"+capItemCat.getId()+".html");
				catNode.setItem(getCatList(capItemCat.getId()));
				
				resultList.add(catNode);
				count ++;
				//第一层只取14条记录
				if (parentId == 0 && count >=14) {
					break;
				}
			//如果是叶子节点
			} else {
				resultList.add("/products/"+capItemCat.getId()+".html|" + capItemCat.getName());
			}
		}
		return resultList;
	}

}
