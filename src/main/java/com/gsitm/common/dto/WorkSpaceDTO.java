/**
 * @programName : WorkSpaceDTO.java
 * @author      : 은종현
 * @date        : 2018-06-11
 * @function    : 근무지 소개
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 은종현	   2018-06-11	초안
 */ 

package com.gsitm.common.dto;

public class WorkSpaceDTO {
	private String workSeq;
	private String workCode;
	private String workName;
	private String workAddr;
	private String workTel;
	private String workDescription;
	private byte[] workImg;
	
	public byte[] getWorkImg() {
		return workImg;
	}
	public void setWorkImg(byte[] workImg) {
		this.workImg = workImg;
	}
	public String getWorkDescription() {
		return workDescription;
	}
	public void setWorkDescription(String workDescription) {
		this.workDescription = workDescription;
	}
	public String getWorkSeq() {
		return workSeq;
	}
	public void setWorkSeq(String workSeq) {
		this.workSeq = workSeq;
	}
	public String getWorkCode() {
		return workCode;
	}
	public void setWorkCode(String workCode) {
		this.workCode = workCode;
	}
	public String getWorkName() {
		return workName;
	}
	public void setWorkName(String workName) {
		this.workName = workName;
	}
	public String getWorkAddr() {
		return workAddr;
	}
	public void setWorkAddr(String workAddr) {
		this.workAddr = workAddr;
	}
	public String getWorkTel() {
		return workTel;
	}
	public void setWorkTel(String workTel) {
		this.workTel = workTel;
	}
	
	
}
