package com.cap.portal.service.impl;

import com.cap.common.pojo.TaotaoResult;
import com.cap.common.utils.HttpClientUtil;
import com.cap.common.utils.RecordException;
import com.cap.mapper.CapAuctionRecordMapper;
import com.cap.pojo.CapAuctionRecord;
import com.cap.pojo.CapItem;
import com.cap.portal.service.AuctionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AuctionServiceImpl implements AuctionService {

    @Value("${REST_BASE_URL}")
    private String REST_BASE_URL;
    @Value("${ITME_INFO_URL}")
    private String ITME_INFO_URL;
    @Value("${ITEM_RECORD_URL}")
    private String ITEM_RECORD_URL;
    @Autowired
    private CapAuctionRecordMapper auctionRecordMapper;
    @Autowired
    public ItemServiceImpl itemService;

//取商品基本信息后将其封装成竞品Auction
    @Override
    public CapItem getAuctionById(Long itemId) {
        try {
            //调用rest的服务查询竞拍品基本信息
            String json = HttpClientUtil.doGet(REST_BASE_URL + ITME_INFO_URL + itemId);
            if (!StringUtils.isBlank(json)) {
                TaotaoResult taotaoResult = TaotaoResult.formatToPojo(json, CapItem.class);
                if (taotaoResult.getStatus() == 200) {
                    CapItem item= (CapItem) taotaoResult.getData();
                    return item;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CapAuctionRecord> findAuctionRecordListById(Long itemId) {
        try {
            //查询商品描述
            String json = HttpClientUtil.doGet(REST_BASE_URL + ITEM_RECORD_URL + itemId);
            //转换成java对象
            TaotaoResult taotaoResult = TaotaoResult.formatToList(json, CapAuctionRecord.class);
            if (taotaoResult.getStatus() == 200) {
                List<CapAuctionRecord> recordList = (List<CapAuctionRecord>) taotaoResult.getData();
                //取商品描述信息
                return recordList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CapAuctionRecord findAuctionRecordById(Long itemId) {
        try {
            //查询商品描述
            String json = HttpClientUtil.doGet(REST_BASE_URL + ITEM_RECORD_URL + itemId);
            //转换成java对象
            TaotaoResult taotaoResult = TaotaoResult.formatToPojo(json, CapAuctionRecord.class);
            if (taotaoResult.getStatus() == 200) {
                CapAuctionRecord record = (CapAuctionRecord) taotaoResult.getData();
                //取商品描述信息
                return record;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CapAuctionRecord> findAuctionRecordListByAcution(CapItem item){

        return null;
    }


    @Override
    public TaotaoResult addAuctionrecord(CapAuctionRecord auctionRecord) throws RecordException {

        //传进来的auctionRecord的从前台传进来的.
       CapItem auction = getAuctionById(auctionRecord.getItemId());
        if (auction.getCountdown().after(new Date()) == false) {// 商品的竞拍时间过期
            throw new RecordException("竞拍时间已经过期");
        } else {// 商品竞拍时间没有过期,判断是否有竞拍记录
            if (findAuctionRecordListByAcution(auction) != null
                    && findAuctionRecordListByAcution(auction).size() > 0) {// 有竞拍记录
                // 高于竞拍最高价

                CapAuctionRecord maxRecord = findAuctionRecordListByAcution(auction).get(0);

                if (auctionRecord.getAuctionprice()
                        < maxRecord.getAuctionprice()) {
                    throw new RecordException("商品竞拍价要高于所有竞拍价");
                }
            } else {// 无竞拍记录
                // 高于起拍价
                if (auctionRecord.getAuctionprice()< auction.getOpeningBid())
                {
                    throw new RecordException("商品竞拍价要高于起拍价");
                }
            }
        }
        //插入竞标记录
        auctionRecordMapper.insert(auctionRecord);
        return TaotaoResult.ok();
    }
}
