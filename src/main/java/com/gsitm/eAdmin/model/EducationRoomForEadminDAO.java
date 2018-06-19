package com.gsitm.eAdmin.model;

import java.util.List;
import java.util.Map;

import com.gsitm.common.dto.EducationRoomDTO;
import com.gsitm.common.dto.EducationRoomPlusWSNameDTO;
import com.gsitm.common.dto.MeetingRoomDTO;

public interface EducationRoomForEadminDAO {

	List<MeetingRoomDTO> getEduRoomList(EducationRoomDTO educationRoomDTO);

	void insertEducationRoomForAdmin(EducationRoomDTO educationRoomDTO);

	EducationRoomPlusWSNameDTO getEducationRoomByEduSeq(EducationRoomDTO educationRoomDTO);

	void updateEduRoomIncludePic(EducationRoomDTO educationRoomDTO);

	void updateEduRoomNotIncludePic(EducationRoomDTO educationRoomDTO);

	void deleteEduRoomForAdmin(EducationRoomDTO educationRoomDTO);

	Map<String, Object> getByteEducationRoomImage(EducationRoomDTO educationRoomDTO);

	List<EducationRoomDTO> getEduRoomByWorkSeq(EducationRoomDTO educationRoomDTO);

	Map<String, Object> getByteEducationRoomImage2(EducationRoomDTO educationRoomDTO);

	Map<String, Object> getByteEducationRoomImage3(EducationRoomDTO educationRoomDTO);


}
