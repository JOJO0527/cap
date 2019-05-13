package com.cap.portal.controller;

import com.cap.common.pojo.TaotaoResult;
import com.cap.pojo.CapAuctionRecord;
import com.cap.pojo.CapItem;
import com.cap.pojo.CapOrderItem;
import com.cap.pojo.CapOrderShipping;
import com.cap.portal.pojo.Order;
import com.cap.portal.service.AuctionService;
import com.cap.portal.service.ItemService;
import com.cap.portal.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/manager")
public class ScannerController {
    @Autowired
    ItemService itemService;
    @Autowired
    AuctionService auctionService;
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/createorder")
    public String scannerOvertime(Model model) {
        try {
            //获取过期商品
            List<CapItem> overtimeItem = itemService.getOvertimeItem();

            for (CapItem item : overtimeItem) {
                //获取过期竞品的id
                Long overtimeItemId = item.getId();

                //获取过期竞品的竞标记录
                CapAuctionRecord auctionRecord = auctionService.findAuctionRecordById(overtimeItemId);
                //获取竞标记录的最高竞标者id
                Long userId = auctionRecord.getUserId();
                //构造ordershipping对象 暂缓
                //构造orderItem对象
                Order order = new Order();
                CapOrderItem orderItem = new CapOrderItem();
                orderItem.setItemId(overtimeItemId + "");
                orderItem.setTitle(item.getTitle());
                orderItem.setPicPath(item.getImage());
                orderItem.setPrice(item.getPrice());
                //构造order对象
                order.setUserId(userId);
                order.setPayment(orderItem.getPrice() + "");
                order.setOrderItem(orderItem);
                //调用服务
                //生成订单后商品下架
                item.setStatus((byte) 2);
                String orderId = orderService.createOrder(order);
            }
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "创建订单出错。请稍后重试！");
            return "error/exception";
        }
    }
}