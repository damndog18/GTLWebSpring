package com.gtl.message.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gtl.message.domain.GtlSawonDto;
import com.gtl.message.persistence.GtlSawonDao;

@Component("gtlSawonService")
public class GtlSawonServiceImpl implements GtlSawonService {
	
	@Autowired
	private GtlSawonDao gtlSawonDao;
	
	@Override
	public String getTime() {
		return gtlSawonDao.getTime();
	}

	@Override
	public String inputDataSawon(GtlSawonDto gtlSawonDto, String sawon_id, String _inputFlag) {
		System.out.println("여기는 inputSawon Service : " + gtlSawonDto + " , " + sawon_id);
		return gtlSawonDao.inputDataSawon(gtlSawonDto, sawon_id, _inputFlag);
	}
}
