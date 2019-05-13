package com.cap.order.controller;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.cap.common.pojo.TaotaoResult;
import com.cap.common.utils.ExceptionUtil;
import com.cap.order.pojo.Order;
import com.cap.order.service.OrderService;

/**
 * 订单Controller
 */
@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	@ResponseBody
	public TaotaoResult createOrder(@RequestBody Order order) {
		try {
//			TaotaoResult result = orderService.createOrder(order, order.getOrderItems(), order.getOrderShipping());
			TaotaoResult result = orderService.createOrder(order, order.getOrderItem());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
//	@RequestMapping(value ="/list/{userid}/{page}/{count}")
	@RequestMapping(value ="/list/{userid}")
    @ResponseBody
//    public  TaotaoResult findOrdersByUseridPaging(@PathVariable Integer page,@PathVariable Integer count,@PathVariable Long userid){
    public  TaotaoResult findOrdersByUseridPaging(@PathVariable Long userid){
	    try {
            TaotaoResult result = orderService.findOrderListByUserid(userid);
            return result;
        }catch (Exception e){
	        e.printStackTrace();
	        return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
        }
    }
}
