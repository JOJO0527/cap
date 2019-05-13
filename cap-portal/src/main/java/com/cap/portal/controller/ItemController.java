package com.cap.portal.controller;

import com.cap.pojo.CapAuctionRecord;
import com.cap.pojo.CapItem;
import com.cap.portal.pojo.ItemInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cap.portal.service.ItemService;

import java.util.List;

/**
 * 商品详情页面展示
 */
//@CrossOrigin(origins = "http://localhost:9090")
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;


    //获取商品的详情页面
    @RequestMapping("/item/{itemId}")
    public String showItem(@PathVariable Long itemId, Model model) {
        ItemInfo item = itemService.getItemById(itemId);
        model.addAttribute("item", item);
        return "item";
    }


//	@RequestMapping("/item/record/{itemId}")
//	public String getItemRecord(@PathVariable Long itemId,Model model){
//		CapAuctionRecord record = itemService.getItemRecordById(itemId);
//		model.addAttribute("record",record);
//		return "item";
//	}
    //获取商品当前最高价
    @RequestMapping(value = "/item/record/{itemId}", produces = MediaType.TEXT_HTML_VALUE + ";charset=utf-8")
    public String getItemRecord(@PathVariable Long itemId) {
        String record = itemService.getItemRecordById(itemId);
        return record;
    }

    //获取商品详细信息
    @RequestMapping(value = "/item/desc/{itemId}", produces = MediaType.TEXT_HTML_VALUE + ";charset=utf-8")
    @ResponseBody
    public String getItemDesc(@PathVariable Long itemId) {
        String string = itemService.getItemDescById(itemId);
        return string;
    }

    //获取商品规格参数
    @RequestMapping(value = "/item/param/{itemId}", produces = MediaType.TEXT_HTML_VALUE + ";charset=utf-8")
    @ResponseBody
    public String getItemParam(@PathVariable Long itemId) {
        String string = itemService.getItemParam(itemId);
        return string;
    }

    @RequestMapping("/item/overtime")
    public String getOvertimeItem(Model model) {
        List<CapItem> itemList = itemService.getOvertimeItem();
        model.addAttribute("overtimeitem", itemList);
        return "item";
    }
}
