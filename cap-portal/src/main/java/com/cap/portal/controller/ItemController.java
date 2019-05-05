package com.cap.portal.controller;

import com.cap.pojo.CapAuctionRecord;
import com.cap.pojo.CapItem;
import com.cap.portal.pojo.ItemInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cap.portal.service.ItemService;

import java.util.List;

/**
 * 商品详情页面展示
 *
 */

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;

	@RequestMapping("/item/{itemId}")
	public String showItem(@PathVariable Long itemId, Model model) {
		ItemInfo item = itemService.getItemById(itemId);
		model.addAttribute("item", item);
		return "item";
	}

	@RequestMapping("/item/record/{itemId}")
	public String getItemRecord(@PathVariable Long itemId,Model model){
		CapAuctionRecord record = itemService.getItemRecordById(itemId);
		model.addAttribute("record",record);
		return "item";
	}
	
	@RequestMapping(value="/item/desc/{itemId}", produces=MediaType.TEXT_HTML_VALUE+";charset=utf-8")
	@ResponseBody
	public String getItemDesc(@PathVariable Long itemId) {
		String string = itemService.getItemDescById(itemId);
		return string;
	}
	
	@RequestMapping(value="/item/param/{itemId}", produces=MediaType.TEXT_HTML_VALUE+";charset=utf-8")
	@ResponseBody
	public String getItemParam(@PathVariable Long itemId) {
		String string = itemService.getItemParam(itemId);
		return string;
	}

	@RequestMapping("/item/overtime")
	public String getOvertimeItem(Model model){
		List<CapItem> itemList = itemService.getOvertimeItem();
		model.addAttribute("overtimeitem",itemList);
		return "item";
	}
}
