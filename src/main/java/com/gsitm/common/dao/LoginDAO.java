package com.gsitm.common.dao;

import com.gsitm.common.dto.EmployeeDTO;

/**
 * @programName : LoginDAO.java
 * @author      : 김동범
 * @date        : 2018. 6. 11. 
 * @function    : 로그인 처리  
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 
 */ 
public interface LoginDAO {

	
	/**
	 * @methodName : loginCheck 
	 * @author     : 김동범 
	 * @date       : 2018. 6. 11. 
	 * @function   : 로그인 체크. id, pw를 통해서 저장된 사원의 수 count  
	 * @param empId : 아이디
	 * @param empPw : 비밀번호
	 * @return
	 */ 
	int loginCheck(String empId, String empPw);
	
	/**
	 * @methodName : empInfo 
	 * @author     : 김동범 
	 * @date       : 2018. 6. 11. 
	 * @function   : 사원 정보를 뿌려주기 위해.. id, 이름, role 값 return  
	 * @param empId : 아이디
	 * @return
	 */ 
	EmployeeDTO empInfo(String empId);
	
}
