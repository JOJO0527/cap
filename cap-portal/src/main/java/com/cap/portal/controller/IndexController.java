package com.cap.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cap.portal.service.ContentService;

@Controller
public class IndexController {

	@Autowired
	private ContentService contentService;

	@RequestMapping("/index")
	public String showIndex(Model model) {
	    //获取首页轮播图数据（广告）
		String adJson = contentService.getContentList();
		model.addAttribute("ad1", adJson);
		return "index";
	}
}
