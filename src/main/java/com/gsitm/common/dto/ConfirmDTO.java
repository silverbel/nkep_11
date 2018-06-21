package com.gsitm.common.dto;

/**
 * @programName : ConfirmDTO.java
 * @author      : 김동범
 * @date        : 2018. 6. 21. 
 * @function    :  
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 
 */ 
public class ConfirmDTO {
	private String conSeq;
	private String rsvSeq;
	private String bossYn;
	private String mgrYn;
	private String reject;
	public String getConSeq() {
		return conSeq;
	}
	public void setConSeq(String conSeq) {
		this.conSeq = conSeq;
	}
	public String getRsvSeq() {
		return rsvSeq;
	}
	public void setRsvSeq(String rsvSeq) {
		this.rsvSeq = rsvSeq;
	}
	public String getBossYn() {
		return bossYn;
	}
	public void setBossYn(String bossYn) {
		this.bossYn = bossYn;
	}
	public String getMgrYn() {
		return mgrYn;
	}
	public void setMgrYn(String mgrYn) {
		this.mgrYn = mgrYn;
	}
	public String getReject() {
		return reject;
	}
	public void setReject(String reject) {
		this.reject = reject;
	}
	
	
}
