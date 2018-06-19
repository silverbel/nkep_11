package com.gsitm.admin.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gsitm.admin.model.dao.NoticeDAO;
import com.gsitm.common.dto.NoticeDTO;

/**
 * @programName : NoticeService.java
 * @author      : 은종현
 * @date        : 2018. 6. 17. 
 * @function    :  
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 
 */ 
@Service
public class NoticeService {

	@Inject
	private NoticeDAO noticeDAO;
	
	public List<NoticeDTO> getNoticeList(NoticeDTO noticeDTO){
		return noticeDAO.getNoticeList(noticeDTO);
	}
	
	public void deleteNotice(NoticeDTO noticeDTO) {
		noticeDAO.deleteNotice(noticeDTO);
	}
	
	public void insert(NoticeDTO noticeDTO) {
		noticeDAO.insertNotice(noticeDTO);
	}

}
