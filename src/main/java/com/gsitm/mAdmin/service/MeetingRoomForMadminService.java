package com.gsitm.mAdmin.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.gsitm.common.dto.MeetingRoomDTO;
import com.gsitm.common.dto.MeetingRoomPlusWSNameDTO;
import com.gsitm.common.dto.WorkSpaceDTO;
import com.gsitm.mAdmin.model.MeetingRoomForMadminDAO;

@Service
public class MeetingRoomForMadminService {

	@Inject
	private MeetingRoomForMadminDAO meetingRoomForMadminDAO;
	public List<MeetingRoomDTO> getMtRoomList(MeetingRoomDTO meetingRoomDTO) {
		return meetingRoomForMadminDAO.getMtRoomList(meetingRoomDTO);
	}
	public void insertMeetingRoomForAdmin(MeetingRoomDTO meetingRoomDTO) {
		meetingRoomForMadminDAO.insertMeetingRoomForAdmin(meetingRoomDTO);
	}
	public Map<String, Object> getByteMeetingRoomImage(MeetingRoomDTO meetingRoomDTO) {
		return meetingRoomForMadminDAO.getByteMeetingRoomImage(meetingRoomDTO);
	}
	public MeetingRoomPlusWSNameDTO getMeetingRoomByMtSeq(MeetingRoomDTO meetingRoomDTO) {
		return meetingRoomForMadminDAO.getMeetingRoomByMtSeq(meetingRoomDTO);
	}
	public void updateMtRoomIncludePic(MeetingRoomDTO meetingRoomDTO) {
		meetingRoomForMadminDAO.updateMtRoomIncludePic(meetingRoomDTO);
	}
	public void updateMtRoomNotIncludePic(MeetingRoomDTO meetingRoomDTO) {
		meetingRoomForMadminDAO.updateMtRoomNotIncludePic(meetingRoomDTO);
	}
	public void deleteMtRoomForAdmin(MeetingRoomDTO meetingRoomDTO) {
		meetingRoomForMadminDAO.deleteMtRoomForAdmin(meetingRoomDTO);
	}
	public List<MeetingRoomDTO> getMtRoomByWorkSeq(MeetingRoomDTO meetingRoomDTO) {
		return meetingRoomForMadminDAO.getMtRoomByWorkSeq(meetingRoomDTO);
	}
	public Map<String, Object> getByteMeetingRoomImage2(MeetingRoomDTO meetingRoomDTO) {
		return meetingRoomForMadminDAO.getByteMeetingRoomImage2(meetingRoomDTO);
	}
	public Map<String, Object> getByteMeetingRoomImage3(MeetingRoomDTO meetingRoomDTO) {
		return meetingRoomForMadminDAO.getByteMeetingRoomImage3(meetingRoomDTO);
	}


}
