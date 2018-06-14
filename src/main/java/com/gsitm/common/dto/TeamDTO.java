package com.gsitm.common.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @programName : TeamDTO.java
 * @author      : 김동범
 * @date        : 2018. 6. 13. 
 * @function    : team DTO
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 
 */ 
public class TeamDTO {

	private String teamSeq;
	private String teamName;
	private String budget;
	private String bossId;

	// join 용 필드
	private List<EmployeeDTO> empList = new ArrayList<>();


	// getter setter
	public List<EmployeeDTO> getEmpList() {
		return empList;
	}

	public void setEmpList(List<EmployeeDTO> empList) {
		this.empList = empList;
	}

	public String getTeamSeq() {
		return teamSeq;
	}

	public void setTeamSeq(String teamSeq) {
		this.teamSeq = teamSeq;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getBossId() {
		return bossId;
	}

	public void setBossId(String bossId) {
		this.bossId = bossId;
	}

}
