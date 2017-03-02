package com.gtl.message.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.gtl.message.domain.GtlSawonDto;

@Component("gtlSawonDao")
public class GtlSawonDaoImpl implements GtlSawonDao {
	
	private String inputString;
	
	// DB 작업을 위한 준비.
	@Autowired
	private SqlSession sqlSession;
	
	// password 암호화 준비.
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	// mybatis mapper 준비.
	private static final String NAMESPACE = "com.gtl.mappers.userInfoMapper";
	
	@Override
	public String getTime() {
		return sqlSession.selectOne(NAMESPACE + ".getTime");
	}
	
	// 사원 정보 입력.
	@Override
	public String inputDataSawon(GtlSawonDto gtlSawonDto, String sawon_id, String _inputFlag){
		
		if(_inputFlag == "input"){
			GtlSawonDto isAlreadyExistDto = new GtlSawonDto();
			
			isAlreadyExistDto = getUserInfoWithId(isAlreadyExistDto, sawon_id);
			
			if(isAlreadyExistDto == null){
				gtlSawonDto.setSawon_pass(passwordEncoder.encode(gtlSawonDto.getSawon_pass()));
				sqlSession.insert(NAMESPACE + ".insertSawon", gtlSawonDto);
				inputString = "정상 입력 완료";
			}
			else{
				inputString = "입력 안 완료 : 중복 ID 입니다.";
			}
		}
		else if(_inputFlag == "update"){
			gtlSawonDto.setSawon_pass(passwordEncoder.encode(gtlSawonDto.getSawon_pass()));
			sqlSession.update(NAMESPACE + ".updateSawon", gtlSawonDto);
			inputString = "정상 입력 완료";
		}
		return inputString;
	}
	
	// 사원 1명의 데이타 뽑아오기.
	public GtlSawonDto getUserInfoWithId(GtlSawonDto getSawonDto, String sawon_id){
		
		getSawonDto = sqlSession.selectOne(NAMESPACE + ".getUserInfoWithId", sawon_id);
		
		if(getSawonDto != null){
			return getSawonDto;
		}
		else{
			return null;
		}
	}
}
