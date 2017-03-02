package com.gtl.message.persistence;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.WebUtils;

import com.gtl.message.domain.GtlSawonDto;

@Component("gtlLoginDao")
public class GtlLoginDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	// password 암호화 준비.
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	HttpServletRequest request;
	
	HttpSession httpSession;
	
	// mybatis mapper 준비.
	private static final String NAMESPACE = "com.gtl.mappers.userInfoMapper";
	
	// 로그인.
	public String loginSawon(GtlSawonDto gtlSawonDto, String sawon_id, String sawon_pass) {
		
		String login = null;
		
		// 현재 request 객체 뽑아오기.
		request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		
		gtlSawonDto.setSawon_id(sawon_id);
		
		// DB에서 id를 기준으로 data 꺼내오기.
		gtlSawonDto = sqlSession.selectOne(NAMESPACE + ".getUserInfoWithId", gtlSawonDto);
		
		// password 검증.
		if(passwordEncoder.matches(sawon_pass, gtlSawonDto.getSawon_pass())){
			// 세션에 넣기
			WebUtils.setSessionAttribute(request, "loggedmsg", "반갑습니다. " + gtlSawonDto.getSawon_name() + " " + gtlSawonDto.getSawon_position() + "님");
			WebUtils.setSessionAttribute(request, "loggedid", gtlSawonDto.getSawon_id());
			login = "로그인 되었슴.";
		}
		else{
			login = "로그인 안 되었슴.";
		}
		return login;
	}
	
	// 로그아웃.
	public String logoutSawon(){
		
		request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		
		// 세션 객체 뽑아오기.
		httpSession = request.getSession();
		
		// 세션 날리기.
		httpSession.invalidate();
		
		return "로그아웃";
	}
}
