package com.gtl.message;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//DB 연결 테스트 코드. Mybatis. Spring TestContext Framework 이용.
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MybatisConnectionTest {
	
	@Autowired
	private SqlSessionFactory sqlFactory;
	
	@Test
	public void testFactory(){
		
	}
	
	public void testSession(){
		try(SqlSession session = sqlFactory.openSession()){
			System.out.println(session);
		}
		catch(Exception err){
			System.out.println(err);
		}
	}
}
