package com.gtl.message.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gtl.message.domain.GtlSawonDto;
import com.gtl.message.persistence.GtlLoginDao;

@Component("gtlLoginService")
public class GtlLoginService {
	
	@Autowired
	private GtlLoginDao gtlLoginDao;
	
	public String loginSawon(GtlSawonDto gtlSawonDto, String sawon_id, String sawon_pass) {
		return gtlLoginDao.loginSawon(gtlSawonDto, sawon_id, sawon_pass);
	}
	
	public String logoutSawon(){
		return gtlLoginDao.logoutSawon();
	}
}
