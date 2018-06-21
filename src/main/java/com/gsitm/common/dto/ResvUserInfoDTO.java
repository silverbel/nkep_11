package com.gsitm.common.dto;

/**
 * @programName : ResvUserInfoDTO.java
 * @author      : 김동범
 * @date        : 2018. 6. 13. 
 * @function    :  
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 
 */ 
public class ResvUserInfoDTO {

	private String rsvSeq;
	private String applYn;
	private String useId;
	private String empName;
	private String email;
	private String teamName;

	public String getRsvSeq() {
		return rsvSeq;
	}

	public void setRsvSeq(String rsvSeq) {
		this.rsvSeq = rsvSeq;
	}

	public String getApplYn() {
		return applYn;
	}

	public void setApplYn(String applYn) {
		this.applYn = applYn;
	}

	public String getUseId() {
		return useId;
	}

	public void setUseId(String useId) {
		this.useId = useId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

}
