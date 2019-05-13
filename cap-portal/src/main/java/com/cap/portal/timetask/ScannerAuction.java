//package com.cap.portal.timetask;
//
//import com.cap.pojo.CapAuctionRecord;
//import com.cap.pojo.CapItem;
//import com.cap.pojo.CapOrderItem;
//import com.cap.pojo.CapOrderShipping;
//import com.cap.portal.pojo.Order;
//import com.cap.portal.service.AuctionService;
//import com.cap.portal.service.ItemService;
//
//import com.cap.portal.service.OrderService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
///*
//* 自定义扫描过期商品自动为其生成订单功能
//*
//*/
//@Lazy(value = false)
//@Component("scannerAuction")
//public class ScannerAuction {
//    @Autowired
//    ItemService itemService;
//    @Autowired
//    AuctionService auctionService;
//    @Autowired
//    OrderService orderService;
//    @Autowired
//    Order order;
//    @Autowired
//    CapOrderItem orderItem;
//    @Autowired
//    CapOrderShipping orderShipping;
////    @Scheduled(cron = "0 0 24 * * ?")
//    @Scheduled(cron="0/5 * *  * * ? ")
//    public void run() {
//        //获取过期商品
//       List<CapItem> overtimeItem = itemService.getOvertimeItem();
//       if(overtimeItem!=null){
//        for (CapItem item :overtimeItem) {
//            //获取过期竞品的id
//            Long overtimeItemId = item.getId();
//            //获取过期竞品的竞标记录
//            CapAuctionRecord auctionRecord = auctionService.findAuctionRecordById(overtimeItemId);
//            //获取竞标记录的最高竞标者id
//            Long userId = auctionRecord.getUserId();
//            //构造ordershipping对象 暂缓
//            //构造orderItem对象
//            orderItem.setItemId(overtimeItemId+"");
//            orderItem.setTitle(item.getTitle());
//            orderItem.setPicPath(item.getImage());
//            orderItem.setPrice(item.getPrice());
//            //构造order对象
//            order.setUserId(userId);
//            order.setPayment(orderItem.getPrice()+"");
//            order.setOrderItem(orderItem);
//            //调用服务
//            orderService.createOrder(order);
//            //生成订单后商品下架
//            item.setStatus((byte)2);
////            System.out.println("自动生成订单成功!");
//        }
//       }
//    }
//}
