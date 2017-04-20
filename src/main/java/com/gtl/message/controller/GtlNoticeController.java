package com.gtl.message.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

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
			mv.addObject("writeUpdate", notice_no);
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
	
	// 공지 사항 쓰기 및 수정.
	@RequestMapping("/input_notice")
	public ModelAndView inputNotice(@ModelAttribute GtlNoticeDto gtlNoticeDto, @RequestParam("sawon_id") String sawon_id, @RequestParam("board_notice_title") String notice_title, @RequestParam("board_notice_note") String notice_note, @RequestParam("notice_no") int notice_no){
		
		String writeNotice = null;
		
		ModelAndView mv = new ModelAndView("notice_pages/notice_input_complete");
		
		if(notice_title.isEmpty() || notice_note.isEmpty()){
			writeNotice = "빈 칸은 용납 못 합니다.";
		}
		else{
			if(notice_no == 0){
				writeNotice = gtlNoticeService.writeNotice(gtlNoticeDto, sawon_id);
			}
			else{
				writeNotice = gtlNoticeService.updateNotice(gtlNoticeDto, notice_no);
			}
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
	
	// 공지 사항 삭제.
	@RequestMapping("/delete_notice")
	public String deleteNotice(@RequestParam("notice_no") int notice_no){
		
		gtlNoticeService.deleteNotice(notice_no);
		
		return "redirect:/notice_main";
	}
	
	@RequestMapping("/cookie_test")	
	public void testCookie(HttpServletResponse response){
	// Cookie 쓰기 설정.
	Cookie writeCookie = new Cookie("TESTCOOKIE", "test");
			
	writeCookie.setMaxAge(24*60*60);
	writeCookie.setPath("/");
			
	response.addCookie(writeCookie);
	}
}
