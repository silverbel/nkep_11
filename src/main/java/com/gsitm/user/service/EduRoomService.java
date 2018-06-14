/**
 * @programName : MtRoomService.java
 * @author      : 은종현
 * @date        : 2018. 6. 14. 
 * @function    : 회의실 서비스
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 은종현 	  2018-06-14    초안 	
 */ 

package com.gsitm.user.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gsitm.common.dto.EducationRoomDTO;
import com.gsitm.user.model.dao.EduRoomDAO;

@Service
public class EduRoomService {

	@Inject
	private EduRoomDAO eduRoomDAO;
	
	public List<EducationRoomDTO> getEduRoomList(EducationRoomDTO educationRoomDTO){
		return eduRoomDAO.getEduRoomList(educationRoomDTO);
	}
}
