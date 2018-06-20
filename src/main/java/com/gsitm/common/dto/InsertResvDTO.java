package com.gsitm.common.dto;

import java.util.Arrays;

public class InsertResvDTO implements Cloneable {
	private String[] SNACK;
	private String[] FIXTURES;
	private String[] EXPENDABLE;
	private String[] empIdList;
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

	public String[] getEmpIdList() {
		return empIdList;
	}

	public void setEmpIdList(String[] empIdList) {
		this.empIdList = empIdList;
	}

	@Override
	public String toString() {
		return "InsertResvDTO [SNACK=" + Arrays.toString(SNACK) + ", FIXTURES=" + Arrays.toString(FIXTURES)
				+ ", EXPENDABLES=" + Arrays.toString(EXPENDABLE) + ", empIdList=" + Arrays.toString(empIdList)
				+ ", today=" + today + ", workSeq=" + workSeq + ", roomType=" + roomType + ", roomSeq=" + roomSeq
				+ ", rsvType=" + rsvType + ", startTime=" + startTime + ", finTime=" + finTime + ", maxCnt=" + maxCnt
				+ "]";
	}

	public String[] getEXPENDABLE() {
		return EXPENDABLE;
	}

	public void setEXPENDABLE(String[] eXPENDABLE) {
		EXPENDABLE = eXPENDABLE;
	}
	
	public InsertResvDTO clone() throws CloneNotSupportedException {
		InsertResvDTO route = (InsertResvDTO) super.clone();
	    route.SNACK = SNACK.clone();
	    route.FIXTURES = FIXTURES.clone();
	    route.EXPENDABLE = EXPENDABLE.clone();
	    route.empIdList = empIdList.clone();
	   	route.today = this.today;
	    route.workSeq = this.workSeq;
	    route.roomType = this.roomType;
	    route.roomSeq = this.roomSeq;
	    route.rsvType = this.rsvType;
	    route.startTime = this.startTime;
	    route.finTime = this.finTime;
	    route.maxCnt = this.maxCnt;
	    return route;
	  }

}
