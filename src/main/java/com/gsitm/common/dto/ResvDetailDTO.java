package com.gsitm.common.dto;

/**
 * @programName : ResvDetailDTO.java
 * @author      : 김동범
 * @date        : 2018. 6. 21. 
 * @function    :  
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 
 */ 
public class ResvDetailDTO {
	private String applYn;
	private String rsvSeq;
	private String useId;
	private String teamSeq;
	public String getApplYn() {
		return applYn;
	}
	public void setApplYn(String applYn) {
		this.applYn = applYn;
	}
	public String getRsvSeq() {
		return rsvSeq;
	}
	public void setRsvSeq(String rsvSeq) {
		this.rsvSeq = rsvSeq;
	}
	public String getUseId() {
		return useId;
	}
	public void setUseId(String useId) {
		this.useId = useId;
	}
	public String getTeamSeq() {
		return teamSeq;
	}
	public void setTeamSeq(String teamSeq) {
		this.teamSeq = teamSeq;
	}
	
	
}
