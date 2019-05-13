package com.cap.controller;

import com.cap.pojo.CapItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import com.cap.common.pojo.EUDataGridResult;
import com.cap.common.pojo.TaotaoResult;
import com.cap.service.ItemService;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 商品管理Controller
 */

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public CapItem getItemById(@PathVariable Long itemId) {
		CapItem capItem = itemService.getItemById(itemId);
		return capItem;
	}
	
	@RequestMapping("/item/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows) {
		EUDataGridResult result = itemService.getItemList(page, rows);
		return result;
	}
	
	@RequestMapping(value="/item/save", method=RequestMethod.POST)
	@ResponseBody
	private TaotaoResult createItem(CapItem item, String desc, String itemParams) throws Exception {
		TaotaoResult result = itemService.createItem(item, desc, itemParams);
		return result;
	}
	//日期转换将表单中的String类型日期转换成Date类型
    @InitBinder
    protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
//
//    @RequestMapping(value="/item/delete")
//    @ResponseBody
//    private void deleteItem(Long itemId) throws Exception {
//        itemService.deleteItem(itemId);
//    }
}
