package com.cap.portal.service;

import com.cap.portal.pojo.SearchResult;

public interface SearchService {

	SearchResult search(String queryString, int page);
}
