package com.gsitm.common.dto;

public class ResvItemDTO {

	private String rsvSeq;
	private String itemSeq;
	
	public ResvItemDTO() {}
	public ResvItemDTO(String rsvSeq, String itemSeq) {
		this.rsvSeq = rsvSeq;
		this.itemSeq = itemSeq;
	}
	public String getRsvSeq() {
		return rsvSeq;
	}
	public void setRsvSeq(String rsvSeq) {
		this.rsvSeq = rsvSeq;
	}
	public String getItemSeq() {
		return itemSeq;
	}
	public void setItemSeq(String itemSeq) {
		this.itemSeq = itemSeq;
	}
	
	
}
