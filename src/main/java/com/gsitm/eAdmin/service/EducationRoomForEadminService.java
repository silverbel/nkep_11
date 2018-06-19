package com.gsitm.eAdmin.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gsitm.common.dto.EducationRoomDTO;
import com.gsitm.common.dto.EducationRoomPlusWSNameDTO;
import com.gsitm.common.dto.MeetingRoomDTO;
import com.gsitm.eAdmin.model.EducationRoomForEadminDAO;

@Service
public class EducationRoomForEadminService {

	@Inject
	private EducationRoomForEadminDAO educationRoomForEadminDAO;
	
	public List<MeetingRoomDTO> getEduRoomList(EducationRoomDTO educationRoomDTO) {
		return educationRoomForEadminDAO.getEduRoomList(educationRoomDTO);
	}

	public void insertEducationRoomForAdmin(EducationRoomDTO educationRoomDTO) {
		educationRoomForEadminDAO.insertEducationRoomForAdmin(educationRoomDTO);
	}

	public EducationRoomPlusWSNameDTO getEducationRoomByEduSeq(EducationRoomDTO educationRoomDTO) {
		return educationRoomForEadminDAO.getEducationRoomByEduSeq(educationRoomDTO);
	}

	public void updateEduRoomIncludePic(EducationRoomDTO educationRoomDTO) {
		educationRoomForEadminDAO.updateEduRoomIncludePic(educationRoomDTO);
	}

	public void updateEduRoomNotIncludePic(EducationRoomDTO educationRoomDTO) {
		educationRoomForEadminDAO.updateEduRoomNotIncludePic(educationRoomDTO);
	}

	public void deleteEduRoomForAdmin(EducationRoomDTO educationRoomDTO) {
		educationRoomForEadminDAO.deleteEduRoomForAdmin(educationRoomDTO);
	}

	public Map<String, Object> getByteEducationRoomImage(EducationRoomDTO educationRoomDTO) {
		return educationRoomForEadminDAO.getByteEducationRoomImage(educationRoomDTO);
	}

	public List<EducationRoomDTO> getEduRoomByWorkSeq(EducationRoomDTO educationRoomDTO) {
		return educationRoomForEadminDAO.getEduRoomByWorkSeq(educationRoomDTO);
	}

	public Map<String, Object> getByteEducationRoomImage2(EducationRoomDTO educationRoomDTO) {
		return educationRoomForEadminDAO.getByteEducationRoomImage2(educationRoomDTO);
	}

	public Map<String, Object> getByteEducationRoomImage3(EducationRoomDTO educationRoomDTO) {
		return educationRoomForEadminDAO.getByteEducationRoomImage3(educationRoomDTO);
	}



}
