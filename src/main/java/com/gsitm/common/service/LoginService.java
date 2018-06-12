package com.gsitm.common.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gsitm.common.dao.LoginDAOImpl;
import com.gsitm.common.dto.EmployeeDTO;

/**
 * @programName : LoginService.java
 * @author      : 김동범
 * @date        : 2018. 6. 11. 
 * @function    : 로그인 처리. 시큐리티 적용 전, 로그인 처리
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 
 */ 
@Service(value="loginService")
public class LoginService {

	@Resource(name="loginDao")
	private LoginDAOImpl lDao;
	
	/**
	 * @methodName : loginCheck 
	 * @author     : 김동범 
	 * @date       : 2018. 6. 11. 
	 * @function   : 로그인 체크
	 * @param empId
	 * @param empPw
	 * @return
	 */ 
	public boolean loginCheck(String empId, String empPw) {
		boolean loginCheck = false;
		
		if(lDao.loginCheck(empId, empPw) != 0) {
			loginCheck = true;
		}
		
		return loginCheck;
	}
	
	/**
	 * @methodName : empInfo 
	 * @author     : 김동범 
	 * @date       : 2018. 6. 11. 
	 * @function   : 입력된 아이디 사원 정보
	 * @param empId
	 * @return
	 */ 
	public EmployeeDTO empInfo(String empId) {
		return lDao.empInfo(empId);
	}
}
