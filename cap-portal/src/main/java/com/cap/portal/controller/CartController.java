package com.cap.portal.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cap.pojo.CapAuctionRecord;
import com.cap.pojo.CapUser;
import com.cap.portal.pojo.Item;
import com.cap.portal.pojo.ItemInfo;
import com.cap.portal.service.AuctionService;
import com.cap.portal.service.CartService;
import com.cap.portal.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cap.common.pojo.TaotaoResult;
import com.cap.portal.pojo.CartItem;
import com.cap.portal.service.CartService;

/**
 * 购物车Controller
 */
@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	@Autowired
    private AuctionService auctionService;
	@Autowired
	private ItemService itemService;

//	@RequestMapping("/add/{itemId}")
//	public String addCartItem(@PathVariable Long itemId,
//			@RequestParam(defaultValue="1")Integer num,
//			HttpServletRequest request, HttpServletResponse response)
//	{
//	    //获取用户信息  //user=null
//        CapUser user = (CapUser) request.getAttribute("user");
//        //获取竞品竞标记录
//        List<CapAuctionRecord> records = auctionService.findAuctionRecordListById(itemId);
//        //给商品竞拍记录排序  //records=null
//        Collections.sort(records, Comparator.comparing(CapAuctionRecord::getAuctionprice).reversed());
//        //获取竞品竞标最高价记录
//        CapAuctionRecord record = records.get(0);
//
//        //获取商品
//        ItemInfo auction = itemService.getItemById(itemId);
//        //判断拍卖时间截止且竞标记录最高者id与用户id相同，才能加入购物车
//        if (record.getUserId().equals(user.getId())&&
//				 new Date().after(auction.getCountdown())){
//            TaotaoResult result = cartService.addCartItem(itemId, num, request, response);
//            return "redirect:/cart/success.html";
//        }
//        return "redirect:/cart/fail.html";
		//	}

	@RequestMapping("/add/{itemId}")
	public String addCartItem(@PathVariable Long itemId,
							  @RequestParam(defaultValue="1")Integer num,
							  HttpServletRequest request, HttpServletResponse response) {
		TaotaoResult result = cartService.addCartItem(itemId, num, request, response);
		return "redirect:/cart/success.html";
	}

	@RequestMapping("/success")
	public String showSuccess() {
		return "cartSuccess";
	}
	@RequestMapping("/fail")
	public String showFail() {
		return "cartFail";
	}
	
	@RequestMapping("/cart")
	public String showCart(HttpServletRequest request, HttpServletResponse response, Model model) {
		List<CartItem> list = cartService.getCartItemList(request, response);
		model.addAttribute("cartList", list);
		return "cart";
	}
	
	@RequestMapping("/delete/{itemId}")
	public String deleteCartItem(@PathVariable Long itemId, HttpServletRequest request, HttpServletResponse response) {
		cartService.deleteCartItem(itemId, request, response);
		return "redirect:/cart/cart.html";
	}
	
}
