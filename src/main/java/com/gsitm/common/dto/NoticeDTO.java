/**
 * @programName : NoticeDTO.java
 * @author      : 은종현
 * @date        : 2018-06-17
 * @function    : 공지사항
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 은종현	   2018-06-17	초안
 */ 
package com.gsitm.common.dto;

import java.sql.Date;

public class NoticeDTO {
	private int noticeNo;
	private String noticeTitle;
	private String noticeContent;
	private Date regDate;
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	
}
