package com.gsitm.admin.model.dao;

import java.util.Map;

import com.gsitm.common.dto.MeetingRoomDTO;

/**
 * @programName : MtForImgDAO.java
 * @author      : 은종현
 * @date        : 2018. 6. 15. 
 * @function    :  
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 
 */ 
public interface MtRoomForImgDAO {

	Map<String, Object> getByteMtImage(MeetingRoomDTO meetingRoomDTO);
}
