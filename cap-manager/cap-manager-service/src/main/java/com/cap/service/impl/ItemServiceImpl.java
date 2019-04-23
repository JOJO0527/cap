package com.cap.service.impl;

import java.util.Date;
import java.util.List;

import com.cap.common.pojo.TaotaoResult;
import com.cap.common.utils.IDUtils;
import com.cap.mapper.CapItemDescMapper;
import com.cap.mapper.CapItemMapper;
import com.cap.mapper.CapItemParamItemMapper;
import com.cap.pojo.*;
import com.cap.pojo.CapItemExample.Criteria;
import com.cap.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.cap.common.pojo.EUDataGridResult;


/**
 * 商品管理Service
 * <p>Title: ItemServiceImpl</p>
 * <p>Description: </p>
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private CapItemMapper itemMapper;
	@Autowired
    private CapItemDescMapper itemDescMapper;
	@Autowired
	private CapItemParamItemMapper itemParamItemMapper;
	@Override
	public EUDataGridResult getItemList (int page, int rows) {
		//查询商品列表
		CapItemExample example = new CapItemExample();
		//分页处理
		PageHelper.startPage(page, rows);
		List<CapItem> list = itemMapper.selectByExample(example);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<CapItem> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;

	}


	@Override
	public CapItem getItemById(long itemId) {

		//TbItem item = itemMapper.selectByPrimaryKey(itemId);
		//添加查询条件
		CapItemExample example = new CapItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<CapItem> list = itemMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			CapItem item = list.get(0);
			return item;
		}
		return null;
	}


	@Override
	public TaotaoResult createItem(CapItem item, String desc, String itemParam) throws Exception {
		//item补全
		//生成商品ID
		Long itemId = IDUtils.genItemId();
		item.setId(itemId);
		// '商品状态，1-正常，2-下架，3-删除',
		item.setStatus((byte) 1);
		item.setCreated(new Date());
		item.setUpdated(new Date());
		//插入到数据库
		itemMapper.insert(item);
		//添加商品描述信息
		TaotaoResult result = insertItemDesc(itemId, desc);
		if (result.getStatus() != 200) {
			throw new Exception();
		}
		//添加规格参数
		result = insertItemParamItem(itemId, itemParam);
		if (result.getStatus() != 200) {
			throw new Exception();
		}
		return TaotaoResult.ok();
	}
	/**
	 * 添加商品描述
	 * <p>Title: insertItemDesc</p>
	 * <p>Description: </p>
	 * @param desc
	 */
	private TaotaoResult insertItemDesc(Long itemId, String desc) {
		CapItemDesc itemDesc = new CapItemDesc();
		itemDesc.setItemId(itemId);
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(new Date());
		itemDesc.setUpdated(new Date());
		itemDescMapper.insert(itemDesc);
		return TaotaoResult.ok();
	}

	/**
	 * 添加规格参数
	 * <p>Title: insertItemParamItem</p>
	 * <p>Description: </p>
	 * @param itemId
	 * @param itemParam
	 * @return
	 */
	private TaotaoResult insertItemParamItem(Long itemId, String itemParam) {
		//创建一个pojo
		CapItemParamItem itemParamItem = new CapItemParamItem();
		itemParamItem.setItemId(itemId);
		itemParamItem.setParamData(itemParam);
		itemParamItem.setCreated(new Date());
		itemParamItem.setUpdated(new Date());
		//向表中插入数据
		itemParamItemMapper.insert(itemParamItem);

		return TaotaoResult.ok();

	}
//
//	public TaotaoResult deleteItem(long itemId){
//
//        CapItemExample example = new CapItemExample();
//        Criteria criteria = example.createCriteria();
//        criteria.andIdEqualTo(itemId);
//        itemMapper.deleteByExample(example);
//	    return  TaotaoResult.ok();
//    }
//

}

