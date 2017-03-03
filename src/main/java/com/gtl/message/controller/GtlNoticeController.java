package com.gtl.message.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gtl.message.domain.GtlNoticeDto;
import com.gtl.message.service.GtlNoticeService;

@Controller
public class GtlNoticeController {
	
	@Autowired
	GtlNoticeService gtlNoticeService;
	
	@RequestMapping("/notice_write")
	public String writeNotice(){
		return "/notice_pages/notice_write";
	}
	
	// 공지 사항 메인.
	@RequestMapping("/notice_main")
	public ModelAndView mainNotice(@ModelAttribute GtlNoticeDto gtlNoticeDto){
		
		ModelAndView mv = new ModelAndView("notice_pages/notice_main");
		
		mv.addObject("mainNotice", gtlNoticeService.mainNotice(gtlNoticeDto));
		
		return mv;
	}
	
	// 공지 사항 쓰기.
	@RequestMapping("/input_notice")
	public ModelAndView inputNotice(@ModelAttribute GtlNoticeDto gtlNoticeDto, @RequestParam("sawon_id") String sawon_id, @RequestParam("board_notice_title") String notice_title, @RequestParam("board_notice_note") String notice_note){
		
		String writeNotice = null;
		
		ModelAndView mv = new ModelAndView("notice_pages/notice_input_complete");
		
		if(notice_title.isEmpty() || notice_note.isEmpty()){
			writeNotice = "빈 칸은 용납 못 합니다.";
		}
		else{
			writeNotice = gtlNoticeService.writeNotice(gtlNoticeDto, sawon_id);
		}
		
		mv.addObject("writeNotice", writeNotice);
		
		return mv;
	}
}