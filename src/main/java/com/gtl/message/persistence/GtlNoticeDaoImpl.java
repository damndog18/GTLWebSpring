package com.gtl.message.persistence;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.gtl.message.domain.GtlNoticeDto;

@Component("gtlNoticeDao")
public class GtlNoticeDaoImpl implements GtlNoticeDao {
	
	// DB 작업을 위한 준비.
	@Autowired
	private SqlSession sqlSession;
	
	// mybatis mapper 준비.
	private static final String NAMESPACE = "com.gtl.mappers.boardNoticeMapper";
	
	HttpServletRequest request;
	
	HttpSession httpSession;
	
	// 공지 사항 쓰기.
	@Override
	public String writeNotice(GtlNoticeDto gtlNoticeDto, String sawon_id) {
		
		gtlNoticeDto.setSawon_id(sawon_id);
		
		sqlSession.insert(NAMESPACE + ".writeNotice", gtlNoticeDto);
			
		return "정상 입력 되었습니다.";
	}
	
	// 공지 사항 목록.
	@Override
	public List<GtlNoticeDto> mainNotice(GtlNoticeDto gtlNoticeDto) {
		
		List<GtlNoticeDto> list = null;
		
		list = sqlSession.selectList(NAMESPACE + ".getBoardNotice", gtlNoticeDto);
		
		return list;
	}
	
	// 공지 사항 읽기.
	@Override
	public GtlNoticeDto readNotice(int notice_no) {
		
		GtlNoticeDto gtlNoticeDto = new GtlNoticeDto();
		
		// request 뽑아오기.
		request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
				
		// 세션 객체 뽑아오기.
		httpSession = request.getSession();
		
		gtlNoticeDto = sqlSession.selectOne(NAMESPACE + ".readNotice", notice_no);
		System.out.println(httpSession.isNew());
		
		// 읽음 카운터 수정.
		if(httpSession.isNew()){
			System.out.println("여기는 readNotice()의 카운터+1");
			sqlSession.update(NAMESPACE + ".updateCounter", gtlNoticeDto);
		}
		
		return gtlNoticeDto;
	}
	
	// 공지 사항 수정.
	@Override
	public String updateNotice(GtlNoticeDto gtlNoticeDto, int notice_no){
		
		gtlNoticeDto.setBoard_notice_no(notice_no);
		
		sqlSession.update(NAMESPACE + ".updateNotice", gtlNoticeDto);
		
		return "정상 수정 되었습니다";
	}
	
	// 공지 사항 삭제.
	@Override
	public void deleteNotice(int notice_no) {
		sqlSession.delete(NAMESPACE + ".deleteNotice", notice_no);
	}
}
