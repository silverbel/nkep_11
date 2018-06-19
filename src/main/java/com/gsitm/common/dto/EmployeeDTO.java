package com.gsitm.common.dto;

public class EmployeeDTO {

	private String empId;
	private String empPw;
	private String empName;
	private String blackYn;
	private String role;
	private String teamSeq;
	private String email;
	private String teamName;

	public EmployeeDTO() {
	}

	public EmployeeDTO(String empId, String empPw) {
		this.setEmpId(empId);
		this.setEmpPw(empPw);
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpPw() {
		return empPw;
	}

	public void setEmpPw(String empPw) {
		this.empPw = empPw;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getBlackYn() {
		return blackYn;
	}

	public void setBlackYn(String blackYn) {
		this.blackYn = blackYn;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getTeamSeq() {
		return teamSeq;
	}

	public void setTeamSeq(String teamSeq) {
		this.teamSeq = teamSeq;
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
