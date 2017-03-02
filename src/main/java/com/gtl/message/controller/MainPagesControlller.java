package com.gtl.message.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPagesControlller {
	
	@RequestMapping("/firstPage")
	public String firstPage(){
		System.out.println("first");
		return "/main_pages/first_page";
	}
	
	@RequestMapping("/secondPage")
	public String secondPage(){
		return "/main_pages/second_page";
	}
	
	@RequestMapping("/thirdPage")
	public String thirdPage(){
		return "/main_pages/third_page";
	}
	
	@RequestMapping("/fourthPage")
	public String fourthPage(){
		return "/main_pages/fourth_page";
	}
}
