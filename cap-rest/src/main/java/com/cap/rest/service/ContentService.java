package com.cap.rest.service;

import java.util.List;

import com.cap.pojo.CapContent;

public interface ContentService {

	List<CapContent> getContentList(long contentCid);
}
