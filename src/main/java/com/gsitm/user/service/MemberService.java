package com.gsitm.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gsitm.common.dto.EmployeeDTO;
import com.gsitm.common.dto.TeamDTO;
import com.gsitm.user.model.dao.MemberDAOImpl;

/**
 * @programName : LoginService.java
 * @author      : 김동범
 * @date        : 2018. 6. 13. 
 * @function    : 회원 정보, 팀 정보를 확인
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 
 */ 
@Service(value="memService")
public class MemberService {

	@Resource(name="memDao")
	private MemberDAOImpl mDao;
	
	public List<EmployeeDTO> showTeamMember(String teamSeq){
		return mDao.showTeamMember(teamSeq);
	}
	
	public TeamDTO showTeamInfo(String empId){
		return mDao.showTeamInfo(empId);
	}
	
	public int memCount(String empId) {
		return mDao.memCount(empId);
	}
}
