package com.gsitm.admin.service;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gsitm.admin.model.dao.MtRoomForImgDAO;
import com.gsitm.common.dto.MeetingRoomDTO;


/**
 * @programName : MtRoomForImgService.java
 * @author      : 은종현
 * @date        : 2018. 6. 15. 
 * @function    :  
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 
 */ 
@Service
public class MtRoomForImgService {

	@Inject
	private MtRoomForImgDAO mtRoomForImgDAO;

	public Map<String, Object> getByteMtImage(MeetingRoomDTO meetingRoomDTO) {
		return mtRoomForImgDAO.getByteMtImage(meetingRoomDTO);
	}

}
