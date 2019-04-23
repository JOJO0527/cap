package com.cap.rest.controller;

import java.util.List;

import com.cap.common.pojo.TaotaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cap.common.utils.ExceptionUtil;
import com.cap.pojo.CapContent;
import com.cap.rest.service.ContentService;

/**
 * 内容管理Controller
 */
@Controller
@RequestMapping("/content")
public class ContentController {

	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/list/{contentCategoryId}")
	@ResponseBody
	public TaotaoResult getContentList(@PathVariable Long contentCategoryId) {
		try {
			List<CapContent> list = contentService.getContentList(contentCategoryId);
			return TaotaoResult.ok(list);
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
}