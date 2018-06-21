package com.gsitm.common.dto;

/**
 * @programName : ResvItemInfoDTO.java
 * @author      : 김동범
 * @date        : 2018. 6. 13. 
 * @function    :  
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 
 */ 
public class ResvItemInfoDTO {

	private String rsvSeq;
	private String itemName;
	private int itemCnt;
	private String roomSeq;
	private String itemSeq;
	private String itemUnit;
	private String itemType;

	public String getRsvSeq() {
		return rsvSeq;
	}

	public void setRsvSeq(String rsvSeq) {
		this.rsvSeq = rsvSeq;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemCnt() {
		return itemCnt;
	}

	public void setItemCnt(int itemCnt) {
		this.itemCnt = itemCnt;
	}

	public String getRoomSeq() {
		return roomSeq;
	}

	public void setRoomSeq(String roomSeq) {
		this.roomSeq = roomSeq;
	}

	public String getItemSeq() {
		return itemSeq;
	}

	public void setItemSeq(String itemSeq) {
		this.itemSeq = itemSeq;
	}

	public String getItemUnit() {
		return itemUnit;
	}

	public void setItemUnit(String itemUnit) {
		this.itemUnit = itemUnit;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

}
