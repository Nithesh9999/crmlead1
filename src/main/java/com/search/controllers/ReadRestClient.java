package com.search.controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.search.dto.Search;
@Component
public class ReadRestClient {

	public Search getLeadInfo(long id) {
		
		try {
		RestTemplate restTemplate =new RestTemplate();
		Search search = restTemplate.getForObject("http://localhost:8080/api/lead/"+id, Search.class);
		return search;
		}catch (Exception e) {
         e.printStackTrace();  
		}
		return null;
		
	}
}
