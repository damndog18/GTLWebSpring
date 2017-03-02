package com.gtl.message.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPagesControlller {
	
	@RequestMapping("/firstPage")
	public String firstPage(){
		return "/report_pages/report_main";
	}
	
	@RequestMapping("/secondPage")
	public String secondPage(){
		return "/report_view_pages/report_view_main";
	}
	
	@RequestMapping("/thirdPage")
	public String thirdPage(){
		return "/sawon_view_pages/sawon_view_main";
	}
	
	@RequestMapping("/fourthPage")
	public String fourthPage(){
		return "/notice_pages/notice_main";
	}
}
