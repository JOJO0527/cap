package com.cap.mapper;

import com.cap.pojo.CapAuctionRecord;
import com.cap.pojo.CapAuctionRecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CapAuctionRecordMapper {
    int countByExample(CapAuctionRecordExample example);

    int deleteByExample(CapAuctionRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CapAuctionRecord record);

    int insertSelective(CapAuctionRecord record);

    List<CapAuctionRecord> selectByExample(CapAuctionRecordExample example);

    CapAuctionRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CapAuctionRecord record, @Param("example") CapAuctionRecordExample example);

    int updateByExample(@Param("record") CapAuctionRecord record, @Param("example") CapAuctionRecordExample example);

    int updateByPrimaryKeySelective(CapAuctionRecord record);

    int updateByPrimaryKey(CapAuctionRecord record);
}