/**
 * @programName : ResvDTO.java
 * @author      : 은종현
 * @date        : 2018-06-11
 * @function    : 예약 서비스
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 은종현	   2018-06-11	초안
 */ 
package com.gsitm.common.dto;

public class ResvDTO {
	private String rsvSeq;
	private double rsvCnt;
	private String rsvDate;
	private String rsvFdate;
	private String roomSeq;
	private double rsvPrice;
	public String getRsvSeq() {
		return rsvSeq;
	}
	public void setRsvSeq(String rsvSeq) {
		this.rsvSeq = rsvSeq;
	}
	public double getRsvCnt() {
		return rsvCnt;
	}
	public void setRsvCnt(double rsvCnt) {
		this.rsvCnt = rsvCnt;
	}
	public String getRsvDate() {
		return rsvDate;
	}
	public void setRsvDate(String rsvDate) {
		this.rsvDate = rsvDate;
	}
	public String getRsvFdate() {
		return rsvFdate;
	}
	public void setRsvFdate(String rsvFdate) {
		this.rsvFdate = rsvFdate;
	}
	public String getRoomSeq() {
		return roomSeq;
	}
	public void setRoomSeq(String roomSeq) {
		this.roomSeq = roomSeq;
	}
	public double getRsvPrice() {
		return rsvPrice;
	}
	public void setRsvPrice(double rsvPrice) {
		this.rsvPrice = rsvPrice;
	}
	
	
}
