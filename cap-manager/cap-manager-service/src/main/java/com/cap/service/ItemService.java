package com.cap.service;

import com.cap.common.pojo.EUDataGridResult;
import com.cap.common.pojo.TaotaoResult;
import com.cap.pojo.CapItem;

import com.cap.pojo.TbItem;
import org.springframework.stereotype.Service;


public interface ItemService {

    CapItem getItemById(long itemId);
    EUDataGridResult getItemList(int page, int rows);
    TaotaoResult createItem(CapItem item, String desc, String itemParam) throws Exception;

}
