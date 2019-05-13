package com.cap.order.service.impl;

import java.util.Date;
import java.util.List;

import com.cap.pojo.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cap.common.pojo.TaotaoResult;
import com.cap.mapper.CapOrderItemMapper;
import com.cap.mapper.CapOrderMapper;
import com.cap.mapper.CapOrderShippingMapper;
import com.cap.order.dao.JedisClient;
import com.cap.order.service.OrderService;

/**
 * 订单管理Service
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private CapOrderMapper orderMapper;
    @Autowired
    private CapOrderItemMapper orderItemMapper;
    @Autowired
    private CapOrderShippingMapper orderShippingMapper;
    @Autowired
    private JedisClient jedisClient;

    @Value("${ORDER_GEN_KEY}")
    private String ORDER_GEN_KEY;
    @Value("${ORDER_INIT_ID}")
    private String ORDER_INIT_ID;
    @Value("${ORDER_DETAIL_GEN_KEY}")
    private String ORDER_DETAIL_GEN_KEY;


    @Override
//	public TaotaoResult createOrder(CapOrder order, List<CapOrderItem> itemList, CapOrderShipping orderShipping) {
    public TaotaoResult createOrder(CapOrder order, CapOrderItem item) {
        //向订单表中插入记录
        //获得订单号
        String string = jedisClient.get(ORDER_GEN_KEY);
        if (StringUtils.isBlank(string)) {
            jedisClient.set(ORDER_GEN_KEY, ORDER_INIT_ID);
        }
        long orderId = jedisClient.incr(ORDER_GEN_KEY);
        //补全pojo的属性
        order.setOrderId(orderId + "");
        //状态：1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭
        order.setStatus(1);
        Date date = new Date();
        order.setCreateTime(date);
        order.setUpdateTime(date);
        //0：未评价 1：已评价
        order.setBuyerRate(0);
        //向订单表插入数据
        orderMapper.insert(order);
        //插入订单明细
//		for (CapOrderItem capOrderItem : itemList) {
//			//补全订单明细
//			//取订单明细id
//			long orderDetailId = jedisClient.incr(ORDER_DETAIL_GEN_KEY);
//			capOrderItem.setId(orderDetailId + "");
//			capOrderItem.setOrderId(orderId + "");
//			//向订单明细插入记录
//			orderItemMapper.insert(capOrderItem);
//		}
     			//补全订单明细
			//取订单明细id
			long orderDetailId = jedisClient.incr(ORDER_DETAIL_GEN_KEY);
			item.setId(orderDetailId + "");
			item.setOrderId(orderId + "");
			//向订单明细插入记录
			orderItemMapper.insert(item);

        //插入物流表
        //补全物流表的属性
//		orderShipping.setOrderId(orderId + "");
//		orderShipping.setCreated(date);
//		orderShipping.setUpdated(date);
//		orderShippingMapper.insert(orderShipping);

        return TaotaoResult.ok(orderId);
    }

    @Override
    public TaotaoResult findOrderListByUserid(Long userid) {
        CapOrderExample example = new CapOrderExample();
        CapOrderExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userid);
        List<CapOrder> orders = orderMapper.selectByExample(example);

        return TaotaoResult.ok(orders);
    }

}
