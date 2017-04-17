package com.gtl.message.service;

import java.util.List;

import com.gtl.message.domain.GtlNoticeDto;

public interface GtlNoticeService {
	public String writeNotice(GtlNoticeDto gtlNoticeDto, String sawon_id);
	public List<GtlNoticeDto> mainNotice(GtlNoticeDto gtlNoticeDto);
	public GtlNoticeDto readNotice(int notice_no);
	public String updateNotice(GtlNoticeDto gtlNoticeDto, int notice_no);
}
