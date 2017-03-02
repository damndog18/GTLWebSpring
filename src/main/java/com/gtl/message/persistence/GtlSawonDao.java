package com.gtl.message.persistence;

import com.gtl.message.domain.GtlSawonDto;

public interface GtlSawonDao {
	public String getTime();
	public String inputDataSawon(GtlSawonDto gtlSawonDto, String sawon_id);
}
