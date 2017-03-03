package com.gtl.message.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gtl.message.domain.GtlNoticeDto;

@Component("gtlNoticeDao")
public class GtlNoticeDaoImpl implements GtlNoticeDao {
	
	// DB 작업을 위한 준비.
	@Autowired
	private SqlSession sqlSession;
	
	// mybatis mapper 준비.
	private static final String NAMESPACE = "com.gtl.mappers.boardNoticeMapper";
	
	// 공지사항 쓰기.
	@Override
	public String writeNotice(GtlNoticeDto gtlNoticeDto, String sawon_id) {
		
		gtlNoticeDto.setSawon_id(sawon_id);
		
		sqlSession.insert(NAMESPACE + ".writeNotice", gtlNoticeDto);
			
		return "정상 입력 되었습니다.";
	}

	@Override
	public List<GtlNoticeDto> mainNotice(GtlNoticeDto gtlNoticeDto) {
		
		List<GtlNoticeDto> list = null;
		
		list = sqlSession.selectList(NAMESPACE + ".getBoardNotice", gtlNoticeDto);
		
		return list;
	}
}
