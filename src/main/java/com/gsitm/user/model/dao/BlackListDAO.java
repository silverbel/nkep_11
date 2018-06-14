
package com.gsitm.user.model.dao;

import java.util.List;

import com.gsitm.common.dto.BlackListLogDTO;

/**
 * @programName : BlackListDAO.java
 * @author      : 김동범
 * @date        : 2018. 6. 12. 
 * @function    :  
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 
 */ 
public interface BlackListDAO {
	
	/**
	 * @methodName : forUserList 
	 * @author     : 김동범 
	 * @date       : 2018. 6. 12. 
	 * @function   : 사용자가 자신의 블랙리스트 기록을 확인하는 함수
	 * @param empId : 현재 사용자
	 * @return : 기록들을 리턴
	 */ 
	List<BlackListLogDTO> forUserList(String empId);
	
	int blackListCount(String empId);
	
}
