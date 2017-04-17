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
	public ModelAndView writeNotice(int notice_no){
		
		String write = null;
		
		ModelAndView mv = new ModelAndView("notice_pages/notice_write");
		
		if(notice_no == 0){
			write = "공지 사항 쓰기";
		}
		else{
			write = "공지 사항 수정";
			mv.addObject("writeUpdate", gtlNoticeService.readNotice(notice_no));
		}
		
		mv.addObject("writeTitle", write);
		
		return mv;
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
	
	// 공지 사항 읽기.
	@RequestMapping("/read_notice")
	public ModelAndView readNotice(@ModelAttribute GtlNoticeDto gtlNoticeDto, @RequestParam("notice_no") int notice_no){
		
		ModelAndView mv = new ModelAndView("notice_pages/notice_read");
		
		gtlNoticeDto = gtlNoticeService.readNotice(notice_no);
		
		mv.addObject("readNotice", gtlNoticeDto);
		
		return mv;
	}
	
	// 공지 사항 수정.
	@RequestMapping("/update_notice")
	public GtlNoticeDto updateNotice(GtlNoticeDto gtlNoticeDto, @RequestParam("notice_no") int notice_no){
		
		gtlNoticeDto = gtlNoticeService.updateNotice(notice_no);
		
		return gtlNoticeDto;
	}
	
	// 공지 사항 삭제.
	@RequestMapping("/delete_notice")
	public void deleteNotice(){}
}
