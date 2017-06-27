package com.gtl.message.persistence;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	HttpServletResponse response;
	
	HttpSession httpSession;
	
	String cookieName = null;
	
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
		
		int flag    = 0;
		cookieName  = "readnoticeno" + Integer.toString(notice_no);
		
		// request, response 뽑아오기.
		request  = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		response = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
				
		// 세션 객체 뽑아오기.
		httpSession = request.getSession();
		
		// 세션에서 로긴시 저장되었던 값 뽑아오기.
		String sawon_id = (String)httpSession.getAttribute("loggedid");
		
		// DB에서 글 내용 가져오기.
		gtlNoticeDto = sqlSession.selectOne(NAMESPACE + ".readNotice", notice_no);
		
		System.out.println(httpSession.isNew());
		
		// Cookie 내용에 따라 읽음 카운터 수정.
		Cookie[] getCookies = request.getCookies();
		
		if(getCookies != null){
			
			for(int i=0; i<getCookies.length; i++){
				System.out.println("모든 쿠키 출력 : " + i + ", " + getCookies[i].getName() + ", " + getCookies[i].getValue());
			}
			
			for(int i=0; i<getCookies.length; i++){
				
				System.out.println("쿠키 : " + getCookies[i].getName() + ", " + getCookies[i].getValue());
				
				System.out.println("실제 값 : " + sawon_id + ", " + notice_no);
				
				if(getCookies[i].getName().equals(sawon_id) && Integer.toString(notice_no).equals(getCookies[i].getValue())){
					System.out.println("이미 읽은 거니까 카운터 그대로임.");
					flag = 1;
				}
				/*
				if(getCookies[i].getName().contains("readnoticeno")){
					if(Integer.toString(notice_no).equals(getCookies[i].getValue())){
						if(getCookies[i].getName().equals(cookieName)){
							System.out.println("이미 읽은 거니까 카운터 그대로임.");
							writeCookie(notice_no);
						}
					}
					else{
						System.out.println("얘는 notice_no가 다름.");
						
						System.out.println("카운터 ++ 함.");
						sqlSession.update(NAMESPACE + ".updateCounter", gtlNoticeDto);
						
						System.out.println(gtlNoticeDto.getBoard_notice_counter());
						System.out.println(gtlNoticeDto.getBoard_notice_no());
												
						// Cookie 쓰기.
						writeCookie(notice_no);
					}
				}
				else{
					System.out.println("얘는 관련 없는 쿠키임.");
				}
				*/
			}
		}
		
		/*
		if(httpSession.isNew()){
			System.out.println("여기는 readNotice()의 카운터+1");
			sqlSession.update(NAMESPACE + ".updateCounter", gtlNoticeDto);
		}
		*/
		
		System.out.println("flag = " + flag);
		
		if(flag == 0){
			System.out.println("여기는 readNotice()의 카운터+1");
			sqlSession.update(NAMESPACE + ".updateCounter", gtlNoticeDto);
			
			// Cookie 쓰기.
			writeCookie(sawon_id, notice_no);
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
	
	// 쿠키 저장 하기.
	public void writeCookie(String sawon_id, int notice_no){		
		
		Cookie writeCookie = new Cookie(sawon_id, Integer.toString(notice_no));
				
		writeCookie.setMaxAge(24*60*60);
		writeCookie.setPath("/");
		
		response.addCookie(writeCookie);
	}
}
