package com.gsitm.common.dto;

/**
 * @programName : BlackListLogDTO.java
 * @author      : 김동범
 * @date        : 2018. 6. 12. 
 * @function    :  
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 
 */ 
public class BlackListLogDTO {

	private String blkSeq;
	private String regDate;
	private String finDate;
	private String blkRes;
	private String repoter;
	private String empId;

	public String getBlkSeq() {
		return blkSeq;
	}

	public void setBlkSeq(String blkSeq) {
		this.blkSeq = blkSeq;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getFinDate() {
		return finDate;
	}

	public void setFinDate(String finDate) {
		this.finDate = finDate;
	}

	public String getBlkRes() {
		return blkRes;
	}

	public void setBlkRes(String blkRes) {
		this.blkRes = blkRes;
	}

	public String getRepoter() {
		return repoter;
	}

	public void setRepoter(String repoter) {
		this.repoter = repoter;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

}
