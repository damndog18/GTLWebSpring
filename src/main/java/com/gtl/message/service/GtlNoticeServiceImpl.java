package com.gtl.message.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gtl.message.domain.GtlNoticeDto;
import com.gtl.message.persistence.GtlNoticeDao;

@Component("gtlNoticeService")
public class GtlNoticeServiceImpl implements GtlNoticeService {
	
	@Autowired
	private GtlNoticeDao gtlNoticeDao;
	
	@Override
	public String writeNotice(GtlNoticeDto gtlNoticeDto, String sawon_id) {
		return gtlNoticeDao.writeNotice(gtlNoticeDto, sawon_id);
	}

	@Override
	public List<GtlNoticeDto> mainNotice(GtlNoticeDto gtlNoticeDto) {
		return gtlNoticeDao.mainNotice(gtlNoticeDto);
	}

	@Override
	public GtlNoticeDto readNotice(int notice_no) {
		return gtlNoticeDao.readNotice(notice_no);
	}
	
	public GtlNoticeDto updateNotice(int notice_no){
		return gtlNoticeDao.updateNotice(notice_no);
	}
}
