/**
 * @programName : EduRoomDAO.java
 * @author      : 은종현
 * @date        : 2018. 6. 14. 
 * @function    : 교육실 DAO
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 은종현 	  2018-06-14    초안 	
 */ 
package com.gsitm.user.model.dao;

import java.util.List;

import com.gsitm.common.dto.EducationRoomDTO;

public interface EduRoomDAO {
	List<EducationRoomDTO> getEduRoomList(EducationRoomDTO educationRoomDTO);
	
	
	List<EducationRoomDTO> getAnyRoomInfo(String roomSeq);
}
