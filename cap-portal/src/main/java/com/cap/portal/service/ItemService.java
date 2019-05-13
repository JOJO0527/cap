package com.cap.portal.service;

import com.cap.pojo.CapAuctionRecord;
import com.cap.pojo.CapItem;
import com.cap.portal.pojo.ItemInfo;

import java.util.List;

public interface ItemService {

	ItemInfo getItemById(Long itemId);
	String getItemDescById(Long itemId);
	String getItemParam(Long itemId);
    String getItemRecordById(Long itemId);
//	CapAuctionRecord getItemRecordById(Long itemId);
	List<CapItem> getOvertimeItem();
}
