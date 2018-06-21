package com.gsitm.user.model.dao;

import java.util.List;

import com.gsitm.common.dto.EmployeeDTO;
import com.gsitm.common.dto.TeamDTO;

/**
 * @programName : LoginDAO.java
 * @author      : 김동범
 * @date        : 2018. 6. 13. 
 * @function    : 사원, 팀에 대한 데이터를 처리하기 위한 인터페이스
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 
 */ 
public interface MemberDAO {

	List<EmployeeDTO> showTeamMember(String empId);

	TeamDTO showTeamInfo(String empId);
	
	int memCount(String empId);
	
	List<EmployeeDTO> allMemberListAjax();
	
}
