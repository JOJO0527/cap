package com.cap.search.dao;

import org.apache.solr.client.solrj.SolrQuery;

import com.cap.search.pojo.SearchResult;

public interface SearchDao {

	SearchResult search(SolrQuery query) throws Exception;
}
