package com.gtl.message.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GtlNoticeController {
	
	
	@RequestMapping("/notice_write")
	public String writeNotice(){
		return "/notice_pages/notice_write";
	}
	
	
}
