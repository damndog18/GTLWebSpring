package com.gtl.message.service;

import com.gtl.message.domain.GtlSawonDto;

public interface GtlSawonService {
	public String getTime();
	public String inputDataSawon(GtlSawonDto gtlSawonDto, String sawon_id, String _inputFlag);
}
