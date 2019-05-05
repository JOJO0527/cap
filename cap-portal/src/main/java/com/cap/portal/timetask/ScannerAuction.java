package com.cap.portal.timetask;

import com.cap.pojo.CapAuctionRecord;
import com.cap.pojo.CapItem;
import com.cap.portal.service.AuctionService;
import com.cap.portal.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;


@Component("scannerAuction")
public class ScannerAuction {
    @Autowired
    ItemService itemService;
    @Autowired
    AuctionService auctionService;
    @Scheduled(cron = "0 0 24 * * ?")
    public Long run() {
        //获取过期商品
       List<CapItem> overtimeItem = itemService.getOvertimeItem();
        for (CapItem item :overtimeItem) {
            Long overtimeItemId = item.getId();
           CapAuctionRecord auctionRecord = auctionService.findAuctionRecordById(overtimeItemId);
          Long userId = auctionRecord.getUserId();
          return userId;
        }
        return null;
    }
}
