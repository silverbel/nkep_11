package com.gsitm.admin.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gsitm.admin.model.dao.EduRoomForImgDAO;
import com.gsitm.common.dto.EducationRoomDTO;


/**
 * @programName : EduRoomForImgService.java
 * @author      : 은종현
 * @date        : 2018. 6. 14. 
 * @function    :  
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 
 */ 
@Service
public class EduRoomForImgService {

	@Inject
	private EduRoomForImgDAO eduRoomForImgDAO;

	public Map<String, Object> getByteEduImage(EducationRoomDTO educationRoomDTO) {
		return eduRoomForImgDAO.getByteEduImage(educationRoomDTO);
	}

}
