package com.gtl.message.persistence;

import java.util.List;

import com.gtl.message.domain.GtlNoticeDto;

public interface GtlNoticeDao {
	public String writeNotice(GtlNoticeDto gtlNoticeDto, String sawon_id);
	public List<GtlNoticeDto> mainNotice(GtlNoticeDto gtlNoticeDto);
	public GtlNoticeDto readNotice(int notice_no);
}
