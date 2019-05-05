package com.cap.portal.service;

import com.cap.common.pojo.TaotaoResult;
import com.cap.common.utils.RecordException;
import com.cap.pojo.CapAuctionRecord;
import com.cap.pojo.CapItem;

import java.util.List;

public interface AuctionService {


    //通过竞品id获取竞拍
    public CapItem getAuctionById(Long itemId);
    //通过竞拍id找竞品和竞标记录列表
//    public Auction findAuctionAndRecordListById(long itemId);
    public List<CapAuctionRecord> findAuctionRecordListById(Long itemId);
    //添加竞标记录
//    public void addAuctionrecord(Auctionrecord auctionRecord) throws RecordException;

    public TaotaoResult addAuctionrecord(CapAuctionRecord auctionRecord) throws RecordException;

    public List<CapAuctionRecord> findAuctionRecordListByAcution(CapItem item);

    public CapAuctionRecord findAuctionRecordById(Long itemId);

}
