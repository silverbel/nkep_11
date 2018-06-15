package com.gsitm.common.dto;

public class EducationRoomDTO {
	private String eduSeq;
	private String eduCode;
	private String eduName;
	private String eduSize;
	private String eduPrice;
	private String eduAvail;
	private String eduDescription;
	private String workSeq;
	private String workCode;
	private byte[] eduImg;
	
	
	public byte[] getEduImg() {
		return eduImg;
	}
	public void setEduImg(byte[] eduImg) {
		this.eduImg = eduImg;
	}
	public String getEduDescription() {
		return eduDescription;
	}
	public void setEduDescription(String eduDescription) {
		this.eduDescription = eduDescription;
	}
	public String getEduSeq() {
		return eduSeq;
	}
	public void setEduSeq(String eduSeq) {
		this.eduSeq = eduSeq;
	}
	public String getEduCode() {
		return eduCode;
	}
	public void setEduCode(String eduCode) {
		this.eduCode = eduCode;
	}
	public String getEduName() {
		return eduName;
	}
	public void setEduName(String eduName) {
		this.eduName = eduName;
	}
	public String getEduSize() {
		return eduSize;
	}
	public void setEduSize(String eduSize) {
		this.eduSize = eduSize;
	}
	public String getEduPrice() {
		return eduPrice;
	}
	public void setEduPrice(String eduPrice) {
		this.eduPrice = eduPrice;
	}
	public String getEduAvail() {
		return eduAvail;
	}
	public void setEduAvail(String eduAvail) {
		this.eduAvail = eduAvail;
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
	
	
}
