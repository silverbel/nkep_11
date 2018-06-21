package com.gsitm.common.dto;

/**
 * @programName : StockDTO.java
 * @author      : 김동범
 * @date        : 2018. 6. 21. 
 * @function    :  
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 
 */ 
public class StockDTO {
	private String stSeq;
	private String stCnt;
	private String workSeq;
	private String itemSeq;
	public String getStSeq() {
		return stSeq;
	}
	public void setStSeq(String stSeq) {
		this.stSeq = stSeq;
	}
	public String getStCnt() {
		return stCnt;
	}
	public void setStCnt(String stCnt) {
		this.stCnt = stCnt;
	}
	public String getWorkSeq() {
		return workSeq;
	}
	public void setWorkSeq(String workSeq) {
		this.workSeq = workSeq;
	}
	public String getItemSeq() {
		return itemSeq;
	}
	public void setItemSeq(String itemSeq) {
		this.itemSeq = itemSeq;
	}
	
	
}
