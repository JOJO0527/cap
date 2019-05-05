package com.cap.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cap.common.pojo.TaotaoResult;
import com.cap.rest.service.ItemService;

/**
 * 商品信息Controller
 */
@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;
	//取商品基本信息
	@RequestMapping("/info/{itemId}")
	@ResponseBody
	public TaotaoResult getItemBaseInfo(@PathVariable Long itemId) {
		TaotaoResult result = itemService.getItemBaseInfo(itemId);
		return result;
	}
	//取商品详细信息
	@RequestMapping("/desc/{itemId}")
	@ResponseBody
	public TaotaoResult getItemDesc(@PathVariable Long itemId) {
		TaotaoResult result = itemService.getItemDesc(itemId);
		return result;
	}
	//取商品规格信息
	@RequestMapping("/param/{itemId}")
	@ResponseBody
	public TaotaoResult getItemParam(@PathVariable Long itemId) {
		TaotaoResult result = itemService.getItemParam(itemId);
		return result;
	}
	//取商品竞标表
	@RequestMapping("/record/{itemId}")
	@ResponseBody
	public TaotaoResult getItemRecord(@PathVariable Long itemId) {
		TaotaoResult result = itemService.getItemRecord(itemId);
		return  result;
	}
	//取过期商品
	@RequestMapping("/overtime")
	@ResponseBody
	public TaotaoResult getOvertimeItem() {
		TaotaoResult result = itemService.getOvertimeItem();
		return  result;
	}

}
