package com.gtl.message.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gtl.message.domain.GtlNoticeDto;

@Controller
public class GtlNoticeController {
	
	
	@RequestMapping("/notice_write")
	public String writeNotice(){
		return "/notice_pages/notice_write";
	}
	
	@RequestMapping("/notice_read")
	public String readNotice(){
		return "/notice_pages/notice_read";
	}
	
	@RequestMapping("/input_notice")
	public ModelAndView inputNotice(@ModelAttribute GtlNoticeDto gtlNoticeDto, @RequestParam("sawon_id") String sawon_id){
		
		ModelAndView mv = new ModelAndView("notice_pages/notice_input_complete");
		
		
		
		return mv;
	}
}
