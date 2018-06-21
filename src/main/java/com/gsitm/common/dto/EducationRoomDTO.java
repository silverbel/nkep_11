package com.gsitm.common.dto;

import java.util.Arrays;

/**
 * @programName : EducationRoomDTO.java
 * @author      : 김동범
 * @date        : 2018. 6. 21. 
 * @function    :  
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 
 */ 
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
	private String eduAvailStime;
	private String eduAvailEtime;
	
	private byte[] eduImg;
	private byte[] eduImg2;
	private byte[] eduImg3;
	
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
	public byte[] getEduImg() {
		return eduImg;
	}
	public void setEduImg(byte[] eduImg) {
		this.eduImg = eduImg;
	}
	public byte[] getEduImg2() {
		return eduImg2;
	}
	public void setEduImg2(byte[] eduImg2) {
		this.eduImg2 = eduImg2;
	}
	public byte[] getEduImg3() {
		return eduImg3;
	}
	public void setEduImg3(byte[] eduImg3) {
		this.eduImg3 = eduImg3;
	}
	public String getEduAvailStime() {
		return eduAvailStime;
	}
	public void setEduAvailStime(String eduAvailStime) {
		this.eduAvailStime = eduAvailStime;
	}
	public String getEduAvailEtime() {
		return eduAvailEtime;
	}
	public void setEduAvailEtime(String eduAvailEtime) {
		this.eduAvailEtime = eduAvailEtime;
	}
	@Override
	public String toString() {
		return "EducationRoomDTO [eduSeq=" + eduSeq + ", eduCode=" + eduCode + ", eduName=" + eduName + ", eduSize="
				+ eduSize + ", eduPrice=" + eduPrice + ", eduAvail=" + eduAvail + ", eduDescription=" + eduDescription
				+ ", workSeq=" + workSeq + ", workCode=" + workCode + ", eduAvailStime=" + eduAvailStime
				+ ", eduAvailEtime=" + eduAvailEtime + ", eduImg=" + Arrays.toString(eduImg) + ", eduImg2="
				+ Arrays.toString(eduImg2) + ", eduImg3=" + Arrays.toString(eduImg3) + ", getEduDescription()="
				+ getEduDescription() + ", getEduSeq()=" + getEduSeq() + ", getEduCode()=" + getEduCode()
				+ ", getEduName()=" + getEduName() + ", getEduSize()=" + getEduSize() + ", getEduPrice()="
				+ getEduPrice() + ", getEduAvail()=" + getEduAvail() + ", getWorkSeq()=" + getWorkSeq()
				+ ", getWorkCode()=" + getWorkCode() + ", getEduImg()=" + Arrays.toString(getEduImg())
				+ ", getEduImg2()=" + Arrays.toString(getEduImg2()) + ", getEduImg3()=" + Arrays.toString(getEduImg3())
				+ ", getEduAvailStime()=" + getEduAvailStime() + ", getEduAvailEtime()=" + getEduAvailEtime()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}
