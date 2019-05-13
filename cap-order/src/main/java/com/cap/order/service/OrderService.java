package com.cap.order.service;

import java.util.List;

import com.cap.common.pojo.TaotaoResult;
import com.cap.pojo.CapOrder;
import com.cap.pojo.CapOrderItem;
import com.cap.pojo.CapOrderShipping;

public interface OrderService {

//	TaotaoResult createOrder(CapOrder order, List<CapOrderItem> itemList, CapOrderShipping orderShipping);
	TaotaoResult createOrder(CapOrder order,CapOrderItem item);
	TaotaoResult findOrderListByUserid(Long userid);
}
