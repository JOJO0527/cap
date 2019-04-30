package com.cap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cap.common.pojo.TaotaoResult;
import com.cap.pojo.CapContent;
import com.cap.service.ContentService;

/**
 * 内容管理Controller
 */
@Controller
@RequestMapping("/content")
public class ContentController {

	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/save")
	@ResponseBody
	public TaotaoResult insertContent(CapContent content) {
		TaotaoResult result = contentService.insertContent(content);
		return result;
	}
}
