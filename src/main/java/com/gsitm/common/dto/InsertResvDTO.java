package com.gsitm.common.dto;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @programName : InsertResvDTO.java
 * @author      : 김동범
 * @date        : 2018. 6. 21. 
 * @function    :  
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 
 */ 
public class InsertResvDTO implements Cloneable {
	private String[] SNACK;
	private String[] FIXTURES;
	private String[] EXPENDABLE;
	private String[] empIdList;
	private String today;
	private String workSeq;
	private String workName;
	private String roomName;
	private String roomType;
	private String roomSeq;
	private String roomPrice;
	private String rsvType;
	private String startTime;
	private String finTime;
	private String maxCnt;
	private String rsvSeq;
	private String rsvCnt;
	private String selDate; // step2에서 선택한 날짜
	private String rsvDate;
	private String rsvFdate;
	private String rsvPrice;
	private String applicant;
	
	private String teamSeq;
	private ArrayList<String> items;
	private ArrayList<String> empIds;
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
				+ ", EXPENDABLE=" + Arrays.toString(EXPENDABLE) + ", empIdList=" + Arrays.toString(empIdList)
				+ ", today=" + today + ", workSeq=" + workSeq + ", workName=" + workName + ", roomName=" + roomName
				+ ", roomType=" + roomType + ", roomSeq=" + roomSeq + ", roomPrice=" + roomPrice + ", rsvType="
				+ rsvType + ", startTime=" + startTime + ", finTime=" + finTime + ", maxCnt=" + maxCnt + ", rsvSeq="
				+ rsvSeq + ", rsvCnt=" + rsvCnt + ", selDate=" + selDate + ", rsvDate=" + rsvDate + ", rsvFdate="
				+ rsvFdate + ", rsvPrice=" + rsvPrice + ", applicant=" + applicant + ", teamSeq=" + teamSeq + ", items="
				+ items + ", empIds=" + empIds + "]";
	}

	public String[] getEXPENDABLE() {
		return EXPENDABLE;
	}

	public void setEXPENDABLE(String[] eXPENDABLE) {
		EXPENDABLE = eXPENDABLE;
	}

	@SuppressWarnings("unchecked")
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
		route.rsvSeq = this.rsvSeq;
		route.rsvCnt = this.rsvCnt;
		route.selDate = this.selDate;
		route.rsvPrice = this.rsvPrice;
		route.applicant = this.applicant;
		route.rsvDate = this.rsvDate;
		route.rsvFdate = this.rsvFdate;
		route.roomPrice = this.roomPrice;
		route.teamSeq = this.teamSeq;
		route.workName = this.workName;
		route.roomName = this.roomName;
		if (route.items != null) {
			route.items = (ArrayList<String>) items.clone();
		}
		if (route.empIds != null) {
			route.empIds = (ArrayList<String>) empIds.clone();
		}
		return route;
	}

	public String getRsvSeq() {
		return rsvSeq;
	}

	public void setRsvSeq(String rsvSeq) {
		this.rsvSeq = rsvSeq;
	}

	public String getRsvCnt() {
		return rsvCnt;
	}

	public void setRsvCnt(String rsvCnt) {
		this.rsvCnt = rsvCnt;
	}

	public String getSelDate() {
		return selDate;
	}

	public void setSelDate(String selDate) {
		this.selDate = selDate;
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

	public String getRsvPrice() {
		return rsvPrice;
	}

	public void setRsvPrice(String rsvPrice) {
		this.rsvPrice = rsvPrice;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public String getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(String roomPrice) {
		this.roomPrice = roomPrice;
	}

	public ArrayList<String> getItems() {
		return items;
	}

	public void setItems(ArrayList<String> items) {
		this.items = items;
	}

	public String getTeamSeq() {
		return teamSeq;
	}

	public void setTeamSeq(String teamSeq) {
		this.teamSeq = teamSeq;
	}

	public ArrayList<String> getEmpIds() {
		return empIds;
	}

	public void setEmpIds(ArrayList<String> empIds) {
		this.empIds = empIds;
	}

	public String getWorkName() {
		return workName;
	}

	public void setWorkName(String workName) {
		this.workName = workName;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	
	
}
