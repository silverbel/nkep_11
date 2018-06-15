package com.gsitm.admin.model.dao;

import java.util.Map;

import com.gsitm.common.dto.EducationRoomDTO;

/**
 * @programName : EduRoomForImgDAO.java
 * @author      : 은종현
 * @date        : 2018. 6. 14. 
 * @function    :  
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 
 */ 
public interface EduRoomForImgDAO {

	Map<String, Object> getByteEduImage(EducationRoomDTO educationRoomDTO);
}
