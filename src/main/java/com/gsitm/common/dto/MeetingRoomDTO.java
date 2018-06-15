package com.gsitm.common.dto;

public class MeetingRoomDTO {
	private String mtSeq;
	private String mtCode;
	private String mtName;
	private String mtSize;
	private String mtPrice;
	private String mtAvail;
	private String mtDescription;
	private String workSeq;
	private String workCode;
	
	private byte[] mtImg;
	private byte[] mtImg2;
	private byte[] mtImg3;
	public String getMtDescription() {
		return mtDescription;
	}
	public void setMtDescription(String mtDescription) {
		this.mtDescription = mtDescription;
	}
	public String getMtSeq() {
		return mtSeq;
	}
	public void setMtSeq(String mtSeq) {
		this.mtSeq = mtSeq;
	}
	public String getMtCode() {
		return mtCode;
	}
	public void setMtCode(String mtCode) {
		this.mtCode = mtCode;
	}
	public String getMtName() {
		return mtName;
	}
	public void setMtName(String mtName) {
		this.mtName = mtName;
	}
	public String getMtSize() {
		return mtSize;
	}
	public void setMtSize(String mtSize) {
		this.mtSize = mtSize;
	}
	public String getMtPrice() {
		return mtPrice;
	}
	public void setMtPrice(String mtPrice) {
		this.mtPrice = mtPrice;
	}
	public String getMtAvail() {
		return mtAvail;
	}
	public void setMtAvail(String mtAvail) {
		this.mtAvail = mtAvail;
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
	public byte[] getMtImg() {
		return mtImg;
	}
	public void setMtImg(byte[] mtImg) {
		this.mtImg = mtImg;
	}
	public byte[] getMtImg2() {
		return mtImg2;
	}
	public void setMtImg2(byte[] mtImg2) {
		this.mtImg2 = mtImg2;
	}
	public byte[] getMtImg3() {
		return mtImg3;
	}
	public void setMtImg3(byte[] mtImg3) {
		this.mtImg3 = mtImg3;
	}
	
	
}
