package com.gsitm.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsitm.common.dto.EducationRoomDTO;
import com.gsitm.common.dto.MeetingRoomDTO;
import com.gsitm.common.dto.WorkSpaceDTO;
import com.gsitm.user.model.dao.EduRoomDAO;
import com.gsitm.user.model.dao.MtRoomDAO;
import com.gsitm.user.model.dao.WorkSpaceDAO;

/**
 * @programName : WorkSpaceService.java
 * @author      : 남동길
 * @date        : 2018. 6. 13. 
 * @function    :  
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 김동범		2018.06.17	교육실, 회의실 dao 추가
 */ 
@Service(value="wServiceForUser")
public class WorkSpaceService {

	@Autowired
	private WorkSpaceDAO workSpaceDAO;
	
	@Autowired
	private MtRoomDAO mtDAO;

	@Autowired
	private EduRoomDAO edDAO;
	
	public List<WorkSpaceDTO> getWorkSpaceList(WorkSpaceDTO workSpaceDTO){
		return workSpaceDAO.getWorkSpaceList(workSpaceDTO);
	}
	
	public List<EducationRoomDTO> getEduRoomList(String workSeq){
		EducationRoomDTO educationRoomDTO = new EducationRoomDTO();
		educationRoomDTO.setWorkSeq(workSeq);
		educationRoomDTO.getWorkSeq();
		return edDAO.getEduRoomList(educationRoomDTO);
	}
	public List<MeetingRoomDTO> getMtRoomList(String workSeq){
		MeetingRoomDTO meetingRoomDTO = new MeetingRoomDTO();
		meetingRoomDTO.setWorkSeq(workSeq);
		return mtDAO.getMtRoomList(meetingRoomDTO);
	}
	
}
