package com.gtl.message.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gtl.message.domain.GtlSawonDto;
import com.gtl.message.service.GtlLoginService;

@Controller
public class GtlLoginController {
	
	@Autowired
	private GtlLoginService gtlLoginService;
	
	@RequestMapping("/login")
	public String gtlLogin(@ModelAttribute GtlSawonDto gtlSawonDto, @RequestParam("sawon_Id") String sawon_id, @RequestParam("sawon_Pass") String sawon_pass){
		
		if(sawon_id == "" || sawon_pass == ""){
			return "redirect:/";
		}
		else{
			gtlLoginService.loginSawon(gtlSawonDto, sawon_id, sawon_pass);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/logout")
	public String gtlLogout(){
		gtlLoginService.logoutSawon();
		return "redirect:/";
	}
}