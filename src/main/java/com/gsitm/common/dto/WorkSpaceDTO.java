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



/**
 * @programName : WorkSpaceDTO.java
 * @author      : 남동길
 * @date        : 2018. 6. 13. 
 * @function    :  
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 
 */ 
public class WorkSpaceDTO {
	private String workSeq;
	private String workCode;
	private String workName;
	private String workAddr;
	private String workTel;
	private String workDescription;
	private byte[] workImg;
	private byte[] workImg2;
	private byte[] workImg3;
	
	private String tel1;
	private String tel2;
	private String tel3;
	private String postCode;
	private String mainAddr;
	private String subAddr;

	private String fTime;
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
	public String getWorkDescription() {
		return workDescription;
	}
	public void setWorkDescription(String workDescription) {
		this.workDescription = workDescription;
	}
	public byte[] getWorkImg() {
		return workImg;
	}
	public void setWorkImg(byte[] workImg) {
		this.workImg = workImg;
	}
	public byte[] getWorkImg2() {
		return workImg2;
	}
	public void setWorkImg2(byte[] workImg2) {
		this.workImg2 = workImg2;
	}
	public byte[] getWorkImg3() {
		return workImg3;
	}
	public void setWorkImg3(byte[] workImg3) {
		this.workImg3 = workImg3;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getMainAddr() {
		return mainAddr;
	}
	public void setMainAddr(String mainAddr) {
		this.mainAddr = mainAddr;
	}
	public String getSubAddr() {
		return subAddr;
	}
	public void setSubAddr(String subAddr) {
		this.subAddr = subAddr;
	}
	public String getTel1() {
		return tel1;
	}
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}
	public String getTel2() {
		return tel2;
	}
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}
	public String getTel3() {
		return tel3;
	}
	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}
	public String getfTime() {
		return fTime;
	}
	public void setfTime(String fTime) {
		this.fTime = fTime;
	}
	
	
	
}
