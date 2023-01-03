package com.search.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.search.dto.Search;

@Controller
public class SearchController {
	@Autowired
   private ReadRestClient readrest;
	@RequestMapping("/search")
	public String viewSearch() {
		return "search_lead";
	}
	@RequestMapping("searchlead")
	public String searchLead(@RequestParam("id")long id,Model model) {
		Search search = readrest.getLeadInfo(id);
		if(search==null) {
			model.addAttribute("msg", "No record ");
			return "search_lead";	
		}
		   else {
			model.addAttribute("search", search);
			return "search_info";	
			}
	}
}
