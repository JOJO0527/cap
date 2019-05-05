package com.cap.rest.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.cap.mapper.CapAuctionRecordMapper;
import com.cap.mapper.CapItemMapper;
import com.cap.pojo.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cap.common.pojo.TaotaoResult;
import com.cap.common.utils.JsonUtils;
import com.cap.mapper.CapItemDescMapper;
import com.cap.mapper.CapItemParamItemMapper;
import com.cap.pojo.CapItemParamItemExample.Criteria;
import com.cap.rest.dao.JedisClient;
import com.cap.rest.service.ItemService;

/**
 * 商品信息管理Service
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private CapItemMapper itemMapper;
	
	@Autowired
	private CapItemDescMapper itemDescMapper;
	
	@Autowired
	private CapItemParamItemMapper itemParamItemMapper;

	@Autowired
	private CapAuctionRecordMapper auctionRecordMapper;

	@Value("${REDIS_ITEM_KEY}")
	private String REDIS_ITEM_KEY;
	@Value("${REDIS_ITEM_EXPIRE}")
	private Integer REDIS_ITEM_EXPIRE;
	
	@Autowired
	private JedisClient jedisClient;
	//取商品基本信息（约等于取商品）
	@Override
	public TaotaoResult getItemBaseInfo(long itemId) {
		try {
			//添加缓存逻辑
			//从缓存中取商品信息，商品id对应的信息
			String json = jedisClient.get(REDIS_ITEM_KEY + ":" + itemId + ":base");
			//判断是否有值
			if (!StringUtils.isBlank(json)) {
				//把json转换成java对象
				CapItem item = JsonUtils.jsonToPojo(json, CapItem.class);
				return TaotaoResult.ok(item);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//根据商品id查询商品信息
		CapItem item = itemMapper.selectByPrimaryKey(itemId);
		//使用TaotaoResult包装一下
		try {
			//把商品信息写入缓存
			jedisClient.set(REDIS_ITEM_KEY + ":" + itemId + ":base", JsonUtils.objectToJson(item));
			//设置key的有效期
			jedisClient.expire(REDIS_ITEM_KEY + ":" + itemId + ":base", REDIS_ITEM_EXPIRE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return TaotaoResult.ok(item);
	}

	//取商品详细信息
	@Override
	public TaotaoResult getItemDesc(long itemId) {
		//添加缓存
		try {
			//添加缓存逻辑
			//从缓存中取商品信息，商品id对应的信息
			String json = jedisClient.get(REDIS_ITEM_KEY + ":" + itemId + ":desc");
			//判断是否有值
			if (!StringUtils.isBlank(json)) {
				//把json转换成java对象
				CapItemDesc itemDesc = JsonUtils.jsonToPojo(json, CapItemDesc.class);
				return TaotaoResult.ok(itemDesc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//创建查询条件
		CapItemDesc itemDesc = itemDescMapper.selectByPrimaryKey(itemId);
		
		try {
			//把商品信息写入缓存
			jedisClient.set(REDIS_ITEM_KEY + ":" + itemId + ":desc", JsonUtils.objectToJson(itemDesc));
			//设置key的有效期
			jedisClient.expire(REDIS_ITEM_KEY + ":" + itemId + ":desc", REDIS_ITEM_EXPIRE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return TaotaoResult.ok(itemDesc);
	}

	//取商品规格参数
	@Override
	public TaotaoResult getItemParam(long itemId) {
		//添加缓存
		try {
			//添加缓存逻辑
			//从缓存中取商品信息，商品id对应的信息
			String json = jedisClient.get(REDIS_ITEM_KEY + ":" + itemId + ":param");
			//判断是否有值
			if (!StringUtils.isBlank(json)) {
				//把json转换成java对象
				CapItemParamItem paramItem = JsonUtils.jsonToPojo(json, CapItemParamItem.class);
				return TaotaoResult.ok(paramItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//设置查询条件
		CapItemParamItemExample example = new CapItemParamItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andItemIdEqualTo(itemId);
		//执行查询
		List<CapItemParamItem> list = itemParamItemMapper.selectByExampleWithBLOBs(example);
		if (list != null && list.size()>0) {
			CapItemParamItem paramItem = list.get(0);
			try {
				//把商品信息写入缓存
				jedisClient.set(REDIS_ITEM_KEY + ":" + itemId + ":param", JsonUtils.objectToJson(paramItem));
				//设置key的有效期
				jedisClient.expire(REDIS_ITEM_KEY + ":" + itemId + ":param", REDIS_ITEM_EXPIRE);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return TaotaoResult.ok(paramItem);
		}
		return TaotaoResult.build(400, "无此商品规格");
	}


	//获取竞品的竞拍记录
    @Override
    public TaotaoResult getItemRecord(long itemId) {
//        //添加缓存
//        try {
//            //添加缓存逻辑
//            //从缓存中取商品信息，商品id对应的信息
//            String json = jedisClient.get(REDIS_ITEM_KEY + ":" + itemId + ":record");
//            //判断是否有值
//            if (!StringUtils.isBlank(json)) {
//                //把json转换成java对象
//                CapAuctionRecord auctionRecord = JsonUtils.jsonToPojo(json, CapAuctionRecord.class);
//                return TaotaoResult.ok(auctionRecord);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        CapAuctionRecordExample example = new CapAuctionRecordExample();
        CapAuctionRecordExample.Criteria criteria = example.createCriteria();
        criteria.andItemIdEqualTo(itemId);
        //执行查询
        List<CapAuctionRecord> list = auctionRecordMapper.selectByExample(example);
        //给list排序 最高价的排在list(0)
		Collections.sort(list, Comparator.comparing(CapAuctionRecord::getAuctionprice).reversed());
        if (list != null && list.size()>0) {
            CapAuctionRecord record = list.get(0);
//            try {
//                //把商品信息写入缓存
//                jedisClient.set(REDIS_ITEM_KEY + ":" + itemId + ":record", JsonUtils.objectToJson(record));
//                //设置key的有效期
//                jedisClient.expire(REDIS_ITEM_KEY + ":" + itemId + ":record", REDIS_ITEM_EXPIRE);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//			}
            return TaotaoResult.ok(record);
        }
        return TaotaoResult.build(400, "无此商品竞标记录");

    }
    @Override
	public TaotaoResult getOvertimeItem(){
		CapItemExample example = new CapItemExample();
		CapItemExample.Criteria criteria = example.createCriteria();
		criteria.andCountdownLessThan(new Date());

		List<CapItem> list = itemMapper.selectByExample(example);
		return TaotaoResult.ok(list);
	}


}
