package com.gsitm.common.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gsitm.common.dto.EmployeeDTO;

/**
 * @programName : LoginDAOImpl.java
 * @author      : 김동범
 * @date        : 2018. 6. 11. 
 * @function    : 로그인 처리, DAO. security 적용 전 로그인 처리
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 
 */ 
@Repository(value="loginDao")
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int loginCheck(String empId, String empPw) {
		EmployeeDTO emp = new EmployeeDTO(empId, empPw);
		return sqlSession.selectOne("member.loginCheck",emp);
	}
	
	@Override
	public EmployeeDTO empInfo(String empId) {
		return sqlSession.selectOne("member.empInfo", empId);
	}
	
	
}
