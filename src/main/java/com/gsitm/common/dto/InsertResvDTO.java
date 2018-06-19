package com.gsitm.common.dto;


public class InsertResvDTO {
	private String[] SNACK;
	private String[] FIXTURES;
	private String[] EXPENDABLES;
	private String today;
	private String workSeq;
	private String roomType;
	private String roomSeq;
	private String rsvType;
	private String startTime;
	private String finTime;
	private String maxCnt;

	public String[] getSNACK() {
		return SNACK;
	}

	public void setSNACK(String[] sNACK) {
		SNACK = sNACK;
	}

	public String[] getFIXTURES() {
		return FIXTURES;
	}

	public void setFIXTURES(String[] fIXTURES) {
		FIXTURES = fIXTURES;
	}

	public String[] getEXPENDABLES() {
		return EXPENDABLES;
	}

	public void setEXPENDABLES(String[] eXPENDABLES) {
		EXPENDABLES = eXPENDABLES;
	}

	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}

	public String getWorkSeq() {
		return workSeq;
	}

	public void setWorkSeq(String workSeq) {
		this.workSeq = workSeq;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getRoomSeq() {
		return roomSeq;
	}

	public void setRoomSeq(String roomSeq) {
		this.roomSeq = roomSeq;
	}

	public String getRsvType() {
		return rsvType;
	}

	public void setRsvType(String rsvType) {
		this.rsvType = rsvType;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getFinTime() {
		return finTime;
	}

	public void setFinTime(String finTime) {
		this.finTime = finTime;
	}

	public String getMaxCnt() {
		return maxCnt;
	}

	public void setMaxCnt(String maxCnt) {
		this.maxCnt = maxCnt;
	}

}
