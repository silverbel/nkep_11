package com.gsitm.user.model.dao;

import java.util.List;

import com.gsitm.common.dto.EmployeeDTO;
import com.gsitm.common.dto.TeamDTO;

/**
 * @programName : LoginDAO.java
 * @author      : �赿��
 * @date        : 2018. 6. 13. 
 * @function    : ���, ���� ���� �����͸� ó���ϱ� ���� �������̽�
 *
 * [�̸�]   [������]     [����]
 * ----------------------------------------------------------
 * 
 */ 
public interface MemberDAO {

	List<EmployeeDTO> showTeamMember(String empId);

	TeamDTO showTeamInfo(String empId);
	
	int memCount(String empId);
	
	List<EmployeeDTO> allMemberListAjax();
	
	void updateBlackList(String empId);
	
}
