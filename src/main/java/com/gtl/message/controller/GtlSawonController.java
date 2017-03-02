package com.gtl.message.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gtl.message.domain.GtlSawonDto;
import com.gtl.message.service.GtlSawonService;

@Controller
public class GtlSawonController {
	
	@Autowired
	private GtlSawonService gtlSawonService;
	
	@RequestMapping("/sub_pages/input_sawon")
	public void inputSawonPage(){}
	
	@RequestMapping("/sub_pages/update_sawon")
	public void updateSawonPage(){}
	
	String inputFlag;
	
	// 사원 정보 입력.
	@RequestMapping(value="/input_sawon", method=RequestMethod.POST)
	public ModelAndView inputSawon(@ModelAttribute GtlSawonDto gtlSawonDto, @RequestParam("sawon_id") String sawon_id, @RequestParam("sawon_pass") String sawon_pass, @RequestParam("sawon_pass_2") String sawon_pass_2){
		inputFlag = "input";
		return isInputCorrect(gtlSawonDto, sawon_id, sawon_pass, sawon_pass_2, inputFlag);
	}
	
	// 사원 정보 수정.
	@RequestMapping(value="/update_sawon", method=RequestMethod.POST)
	public ModelAndView updateSawon(@ModelAttribute GtlSawonDto gtlSawonDto, @RequestParam("sawon_id") String sawon_id, @RequestParam("sawon_pass") String sawon_pass, @RequestParam("sawon_pass_2") String sawon_pass_2){
		inputFlag = "update";
		return isInputCorrect(gtlSawonDto, sawon_id, sawon_pass, sawon_pass_2, inputFlag);
	}
	
	// 입력, 수정 검증 하기.
	public ModelAndView isInputCorrect(GtlSawonDto gtlSawonDto, String sawon_id, String sawon_pass, String sawon_pass_2, String _inputFlag){
		
		ModelAndView mv = new ModelAndView("sub_pages/input_complete");
		
		if(!sawon_pass.equals(sawon_pass_2)){
			mv.addObject("inputSawon", "입력 안 완료 : password 입력 오류.");
		}
		else if(sawon_id == null){
			mv.addObject("inputSawon", "입력 안 완료 : id 입력 오류(null).");
		}
		else{
			mv.addObject("inputSawon", gtlSawonService.inputDataSawon(gtlSawonDto, sawon_id, _inputFlag));
		}
		
		return mv;
	}
}
